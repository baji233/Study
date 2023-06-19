package com.itmk.web.member_course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
@TableName("member_course")
public class MemberCourse {
    @TableId(type = IdType.AUTO)
    private Long memberCourseId;
    private Long courseId;
    private Long memberId;
    private Long teacherId;
    private String courseName;
    private String image;
    private String teacherName;
    private Integer courseHour;
    private String courseDetails;
    private BigDecimal coursePrice;
}
