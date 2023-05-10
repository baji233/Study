package com.jiuyun.service;

import com.jiuyun.bean.User;
import com.jiuyun.dao.UserDao;
import com.jiuyun.service.interf.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public boolean registerUser(String userName, String password) {
        return UserDao.registerUser(userName,password);
    }

    @Override
    public List<User> loginUser(String userName, String password) {
        return UserDao.loginUser(userName,password);
    }

    @Override
    public boolean changePassword(String newPassword, String oldPassword, String userName) {
        return UserDao.changePassword(newPassword,oldPassword,userName);
    }

    @Override
    public List<User> checkUserName(String userName) {
        return UserDao.checkUserName(userName);
    }
}
