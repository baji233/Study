package com.jiuyun.service.impl;

import com.jiuyun.dao.StudentDao;
import com.jiuyun.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;

public class StudentServiceImpl implements StudentService, ApplicationContextAware {
    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Resource //表明这个对象需要依赖注入
    private StudentDao studentDao;
    private ApplicationContext applicationContext;

    //通过set方法依赖注入..
    public void setStudentDao(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    public void save() {
        log.info("StudentServiceImpl.save()");
        studentDao.save();
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
