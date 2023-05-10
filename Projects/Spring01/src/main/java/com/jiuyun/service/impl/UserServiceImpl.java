package com.jiuyun.service.impl;

import com.jiuyun.dao.UserDao;
import com.jiuyun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

@Scope("prototype")  //作用域：在此bean指定为singleton或prototype
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public void delete() {
        log.info("UserServiceImpl.delete()");
        userDao.delete();
    }

}
