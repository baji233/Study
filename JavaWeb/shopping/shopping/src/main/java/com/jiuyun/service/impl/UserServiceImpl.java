package com.jiuyun.service.impl;

import com.jiuyun.bean.User;
import com.jiuyun.dao.UserDAO;
import com.jiuyun.service.UserService;

import java.util.List;

/**
 * @author cj
 * @create 2022年10月15日 18:56:03
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Override
    public boolean save(User user) {
        userDAO = new UserDAO();
        return userDAO.save(user);
    }

    @Override
    public boolean delete(Integer userId) {
        userDAO = new UserDAO();
        return userDAO.delete(userId);
    }

    @Override
    public boolean update(User user) {
        userDAO = new UserDAO();
        return userDAO.update(user);
    }

    @Override
    public User selectById(Integer userId) {
        userDAO = new UserDAO();
        return userDAO.selectById(userId);
    }

    @Override
    public User login(String userName, String password) {
        userDAO = new UserDAO();
        return userDAO.login(userName, password);
    }

    @Override
    public List<User> selectAll() {
        userDAO = new UserDAO();
        return userDAO.selectAll();
    }

    @Override
    public User checkUserName(String userName) {
        userDAO = new UserDAO();
        return userDAO.checkUserName(userName);
    }
}
