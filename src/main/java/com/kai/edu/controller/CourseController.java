package com.kai.edu.controller;


import com.kai.edu.entity.Course;
import com.kai.edu.entity.vo.CourseInformation;
import com.kai.edu.entity.vo.CourseVo;
import com.kai.edu.entity.vo.R;
import com.kai.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-06-15
 */
@RestController
@RequestMapping("ssm-web/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    //分页获取课程列表数据&多条件查询
    @PostMapping("findAllCourse")
    public R  findAllCourse(@RequestBody(required = false)CourseVo courseVo){
        R r = courseService.selCourse(courseVo);
        return r;

    }
    //图片上传
    @PostMapping("courseUpload")
    @CrossOrigin
    public R fileUpload(@RequestParam("file") MultipartFile file){

        try {
            R upload = courseService.upload(file);
            return upload;
        } catch (Exception e) {
            e.printStackTrace();
          return   R.error();
        }


    }

    //添加or修改
    @PostMapping("")
    public R saveOrUpdateCourse(@RequestBody CourseInformation courseInformation){

        courseService.saveOrUpdate(courseInformation);
        return R.ok();
    }


}

//http://xueyuan-teacher.oss-cn-beijing.aliyuncs.com04/422325f2-2171-42ba-b0ba-036289447d8f120.png
//http://xueyuan-teacher.oss-cn-beijing.aliyuncs.com/04/422325f2-2171-42ba-b0ba-036289447d8f120.png