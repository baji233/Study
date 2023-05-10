package com.jiuyun.service;

import com.jiuyun.bean.User;

import java.util.List;

/**
 * @author cj
 * @create 2022年10月15日 18:45:29
 */
public interface UserService {
    boolean save(User user);
    boolean delete(Integer userId);
    boolean update(User user);
    User selectById(Integer userId);
    User login(String userName, String password);
    List<User> selectAll();
    User checkUserName(String userName);
}
