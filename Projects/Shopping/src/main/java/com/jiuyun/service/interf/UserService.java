package com.jiuyun.service.interf;

import com.jiuyun.bean.User;

import java.util.List;

public interface UserService {

    boolean userRegister(User user);
    boolean userDelete(Integer userId);
    boolean updatePassword(String name,String oldPassword,String newPassword);
    List<User> selectAllUsers();
    List<User> selectById(Integer userId);
    List<User> userLogin(String userName, String password);
    List<User> checkUserName(String userName);

}
