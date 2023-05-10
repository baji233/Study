package com.jiuyun.service.impl;

import com.jiuyun.bean.Student;
import com.jiuyun.dao.StudentDAO;
import com.jiuyun.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cj
 * @create 2022年11月25日 19:00:24
 */
@Slf4j
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDAO studentDAO;

    @Override
    public void save(Student student) {
        studentDAO.save(student);
    }
}
