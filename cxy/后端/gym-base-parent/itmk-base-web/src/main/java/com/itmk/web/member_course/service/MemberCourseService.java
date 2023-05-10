package com.itmk.web.member_course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itmk.web.member_course.entity.MemberCourse;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
public interface MemberCourseService extends IService<MemberCourse> {
    //报名
    void joinCourse(MemberCourse memberCourse);
}
