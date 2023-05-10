package com.jiuyun.service.impl;

import com.jiuyun.dao.UserDAO;
import com.jiuyun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cj
 * @create 2022年11月01日 18:12:03
 */
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void save() {
        log.info("this is UserServiceImpl.save() method!");
        userDAO.save();
    }
}
