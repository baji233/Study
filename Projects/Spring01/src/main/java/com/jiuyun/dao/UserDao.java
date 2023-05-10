package com.jiuyun.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao {
    private static final Logger log = LoggerFactory.getLogger(UserDao.class);

    public void delete(){
        log.info("UserDao.delete()");
    }
}
