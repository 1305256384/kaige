package com.kai.edu.service;

import com.kai.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kai.edu.entity.vo.CourseInformation;
import com.kai.edu.entity.vo.CourseVo;
import com.kai.edu.entity.vo.R;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-06-15
 */
public interface CourseService extends IService<Course> {
    //条件查询课程
    R selCourse(CourseVo courseVo);
    //上传oss图片
    R upload(MultipartFile file) throws IOException;

    R saveOrUpdate(CourseInformation courseInformation);
}
