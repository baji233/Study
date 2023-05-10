package com.jiuyun.service;

import com.jiuyun.bean.User;
import com.jiuyun.dao.UserDao;
import com.jiuyun.service.interf.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDao();

    @Override
    public boolean userRegister(User user) {
        return userDao.userRegister(user);
    }

    @Override
    public boolean userDelete(Integer userId) {
        return userDao.userDelete(userId);
    }

    @Override
    public boolean updatePassword(String name, String oldPassword, String newPassword) {
        return userDao.updatePassword(name,oldPassword,newPassword);
    }

    @Override
    public List<User> selectAllUsers() {
        return userDao.selectAllUsers();
    }

    @Override
    public List<User> selectById(Integer userId) {
        return userDao.selectById(userId);
    }

    @Override
    public List<User> userLogin(String userName, String password) {
        return userDao.userLogin(userName, password);
    }

    @Override
    public List<User> checkUserName(String userName) {
        return userDao.checkUserName(userName);
    }
}
