package com.jiuyun.service.impl;

import com.jiuyun.bean.User;
import com.jiuyun.dao.UserDAO;
import com.jiuyun.service.UserService;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;

    @Override
    public User selectById(Integer id) {
        userDAO.selectById(id);
    }
}
