package com.kai.edu.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kai.edu.entity.Course;
import com.kai.edu.entity.vo.CourseInformation;
import com.kai.edu.entity.vo.CourseVo;
import com.kai.edu.entity.vo.R;
import com.kai.edu.mapper.CourseMapper;
import com.kai.edu.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-06-15
 */
@Service
@Transactional
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Override
    public R selCourse(CourseVo courseVo) {

        if(courseVo ==null){
            return R.ok().content(baseMapper.selectList(null));
        }
        String courseName = courseVo.getCourseName();
        Integer status = courseVo.getStatus();

        QueryWrapper queryWrapper = new QueryWrapper();

        if (!StringUtils.isEmpty(courseName)){
            queryWrapper.eq("course_name",courseName);
        }
        if(!StringUtils.isEmpty(status)){
            queryWrapper.eq("status",status);
        }
        List list = baseMapper.selectList(queryWrapper);
        return R.ok().content(list);
    }

    @Override
    public R upload(MultipartFile file) throws IOException {

        InputStream inputStream = file.getInputStream();


        String originalFilename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();

        originalFilename = new String(originalFilename.getBytes(),"utf-8");
        String fileName= uuid+originalFilename;
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
// 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "LTAI5tKo72E541idnQ5Q82rX";
        String accessKeySecret = "KywWhvfjDnnyhrc3H4YasGn9l363i7";

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);


// 创建PutObjectRequest对象。
// 填写Bucket名称、Object完整路径和本地文件的完整路径。Object完整路径中不能包含Bucket名称。
// 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件。
        String bucketName="xueyuan-teacher";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, "04/"+fileName, inputStream);

// 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
// ObjectMetadata metadata = new ObjectMetadata();
// metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
// metadata.setObjectAcl(CannedAccessControlList.Private);
// putObjectRequest.setMetadata(metadata);

// 上传文件。
        ossClient.putObject(putObjectRequest);
        //http://xueyuan-teacher.oss-cn-beijing.aliyuncs.com/04/fileName
       String endpointurl = "oss-cn-beijing.aliyuncs.com";
        String url ="http://"+bucketName+"."+endpointurl+"/04/"+fileName;
// 关闭OSSClient。

        URL url1 = ossClient.generatePresignedUrl(bucketName, "/04/" + fileName, new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 180));
        System.out.println(url);
        ossClient.shutdown();
        ArrayList arrayList = new ArrayList();
        arrayList.add(url);
        return R.ok().content(arrayList);

    }

    @Override
    public R saveOrUpdate(CourseInformation courseInformation) {

        Integer id = courseInformation.getId();


        if(id==null){
            //添加
            Course course = new Course();
            course.setCourseName(courseInformation.getCourseName());
            course.setBrief(courseInformation.getBrief());
            course.setPreviewFirstField(courseInformation.getPreviewFirstField());
            course.setPreviewSecondField(courseInformation.getPreviewSecondField());
            //course.setDiscounts(courseInformation.getDiscounts();
            course.setPrice(courseInformation.getPrice());


        }else {
            //修改
        }


        return null;
    }
}
