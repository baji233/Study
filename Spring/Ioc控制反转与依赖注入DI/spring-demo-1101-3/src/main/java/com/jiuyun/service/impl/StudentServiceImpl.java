package com.jiuyun.service.impl;

import com.jiuyun.dao.StudentDAO;
import com.jiuyun.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cj
 * @create 2022年11月01日 19:53:26
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Resource
    private StudentDAO studentDAO;

    public void save() {
        log.info("this is StudentServiceImpl.save() method!");
        studentDAO.save();
    }
}
