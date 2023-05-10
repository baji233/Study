package com.jiuyun.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentDao {
    private static final Logger log = LoggerFactory.getLogger(StudentDao.class);

    public void save(){
        log.info("StudentDao.save()");
    }

    //初始化bean
    public void initialize() {
        log.info("initialize");
    }

    //销毁bean
    public void destroy() {
        log.info("destroy");
    }

}
