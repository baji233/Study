package com.jiuyun.service.impl;

import com.jiuyun.bean.Student;
import com.jiuyun.dao.StudentDAO;
import com.jiuyun.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDAO studentDAO;
    public void save(Student student) {
//        log.info("this is StudentServiceImpl.save() method!");
//        long start = System.currentTimeMillis();

        studentDAO.save(student);//这行是切入点

//        long end = System.currentTimeMillis();
//        log.info("共耗时：" + (end - start) + "毫秒！");
    }

    public void update(Student student) {
        studentDAO.update(student);
    }
}
