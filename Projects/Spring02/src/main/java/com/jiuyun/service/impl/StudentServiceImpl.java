package com.jiuyun.service.impl;

import com.jiuyun.dao.StudentDAO;
import com.jiuyun.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    private StudentDAO studentDAO;

    @Autowired
    public void setStudentDAO(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    public void book() {
        log.info("StudentServiceImpl的book方法");
        studentDAO.dao();
    }
}
