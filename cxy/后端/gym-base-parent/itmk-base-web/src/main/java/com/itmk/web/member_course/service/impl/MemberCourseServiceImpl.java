package com.itmk.web.member_course.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmk.web.course.entity.Course;
import com.itmk.web.course.service.CourseService;
import com.itmk.web.member.entity.RechargeParm;
import com.itmk.web.member.mapper.MemberMapper;
import com.itmk.web.member_course.entity.MemberCourse;
import com.itmk.web.member_course.mapper.MemberCourseMapper;
import com.itmk.web.member_course.service.MemberCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Service
public class MemberCourseServiceImpl extends ServiceImpl<MemberCourseMapper, MemberCourse> implements MemberCourseService {
    @Autowired
    private CourseService courseService;
    @Resource
    private MemberMapper memberMapper;

    @Override
    @Transactional
    public void joinCourse(MemberCourse memberCourse) {
        //根据课程id查询课程信息
        Course course = courseService.getById(memberCourse.getCourseId());
        BeanUtils.copyProperties(course,memberCourse);
        //查询报名表
        int insert = this.baseMapper.insert(memberCourse);
        if(insert > 0){
            //扣减会员的充值金额
            RechargeParm parm = new RechargeParm();
            parm.setMemberId(memberCourse.getMemberId());
            parm.setMoney(course.getCoursePrice());
            memberMapper.subMoney(parm);
        }
    }
}
