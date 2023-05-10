package com.jiuyun.service.interf;

import com.jiuyun.bean.User;

import java.util.List;

public interface UserService {
    /**
     * 用户注册
     * @param userName 用户名
     * @param password 密码
     * @return 是否成功
     */
    boolean registerUser(String userName,String password);

    /**
     * 用户登录
     * @param userName 用户名
     * @param password 密码
     * @return 用户信息结果集（要进行非空判断用户是否存在）
     */

    List<User> loginUser(String userName,String password);
    /**
     * 修改密码
     * @param newPassword 新密码
     * @param oldPassword 原密码
     * @param userName 用户名称
     * @return isSuccessful
     */
    boolean changePassword(String newPassword,String oldPassword,String userName);

    /**
     * 验证用户名是否可用
     * @param userName
     * @return true:可用
     */
    List<User> checkUserName(String userName);
}
