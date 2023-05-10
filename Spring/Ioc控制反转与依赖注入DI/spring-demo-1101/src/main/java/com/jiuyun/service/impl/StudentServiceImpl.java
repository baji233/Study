package com.jiuyun.service.impl;

import com.jiuyun.dao.StudentDAO;
import com.jiuyun.dao.UserDAO;
import com.jiuyun.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author cj
 * @create 2022年11月01日 15:16:00
 */
public class StudentServiceImpl implements StudentService, ApplicationContextAware {
    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    private StudentDAO studentDAO;
    private ApplicationContext applicationContext = null;

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void save() {
        log.info("this is StudentServiceImpl.save() method!");
        studentDAO.save();
        UserDAO userDAO = (UserDAO) applicationContext.getBean("userDAO");
        userDAO.save();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
