package com.kai.edu.entity.vo;


import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class CourseInformation {

    private Integer id;
    private String courseName;
    private String brief;
    private String teacherName;
    private String description;
    private String position;
    private String previewFirstField;
    private String previewSecondField;
    private String discounts;
    private Double price;
    private String discountsTag;
    private String courseImgUrl;
    private String courseListImg;
    private Integer sortNum;
    private String course_description_mark_down;
    private Integer sales;





}
