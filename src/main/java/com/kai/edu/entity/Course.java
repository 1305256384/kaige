package com.kai.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2021-06-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Course对象", description="")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "课程名")
    private String courseName;

    @ApiModelProperty(value = "课程一句话简介")
    private String brief;

    @ApiModelProperty(value = "原价")
    private Double price;

    @ApiModelProperty(value = "原价标签")
    private String priceTag;

    @ApiModelProperty(value = "优惠价")
    private Double discounts;

    @ApiModelProperty(value = "优惠标签")
    private String discountsTag;

    @ApiModelProperty(value = "描述markdown")
    private String courseDescriptionMarkDown;

    @ApiModelProperty(value = "课程描述")
    private String courseDescription;

    @ApiModelProperty(value = "课程分享图片url")
    private String courseImgUrl;

    @ApiModelProperty(value = "是否新品")
    private Boolean isNew;

    @ApiModelProperty(value = "广告语")
    private String isNewDes;

    @ApiModelProperty(value = "最后操作者")
    private Integer lastOperatorId;

    @ApiModelProperty(value = "自动上架时间")
    private Date autoOnlineTime;

    @ApiModelProperty(value = "记录创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除")
    private Boolean isDel;

    @ApiModelProperty(value = "总时长(分钟)")
    private Integer totalDuration;

    @ApiModelProperty(value = "课程列表展示图片")
    private String courseListImg;

    @ApiModelProperty(value = "课程状态，0-草稿，1-上架")
    private Integer status;

    @ApiModelProperty(value = "课程排序，用于后台保存草稿时用到")
    private Integer sortNum;

    @ApiModelProperty(value = "课程预览第一个字段")
    private String previewFirstField;

    @ApiModelProperty(value = "课程预览第二个字段")
    private String previewSecondField;

    @ApiModelProperty(value = "销量")
    private Integer sales;


}
