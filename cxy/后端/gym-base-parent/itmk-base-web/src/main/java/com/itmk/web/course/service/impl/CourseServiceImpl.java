package com.itmk.web.course.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmk.web.course.entity.Course;
import com.itmk.web.course.mapper.CourseMapper;
import com.itmk.web.course.service.CourseService;
import org.springframework.stereotype.Service;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
}
