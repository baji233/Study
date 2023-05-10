package com.jiuyun.service.impl;

import com.jiuyun.bean.Student;
import com.jiuyun.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年11月23日 20:04:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentServiceImplTest {
    @Resource
    private StudentService studentService;

    @Test
    public void save() {
        studentService.save(Student.builder().stuId(1).stuName("jack").build());
    }

    @org.junit.Test
    public void update() {
        studentService.update(Student.builder().stuId(1).stuName("jack").build());
    }
}