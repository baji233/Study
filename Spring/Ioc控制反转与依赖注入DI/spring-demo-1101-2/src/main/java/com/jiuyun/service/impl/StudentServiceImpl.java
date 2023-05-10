package com.jiuyun.service.impl;

import com.jiuyun.dao.StudentDAO;
import com.jiuyun.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cj
 * @create 2022年11月01日 18:57:38
 */
@Service("studentService")
@Scope("prototype")
public class StudentServiceImpl implements StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
//    @Autowired
    @Resource   //注入
    private StudentDAO studentDAO;

//    @Autowired
//    public void setStudentDAO(StudentDAO studentDAO) {
//        this.studentDAO = studentDAO;
//    }

    public void save() {
        log.info("this is StudentServiceImpl.save() method!");
        studentDAO.save();
    }
}
