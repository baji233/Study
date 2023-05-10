package com.jiuyun.dao;

import com.jiuyun.bean.User;
import com.jiuyun.util.CommonUtil;

import java.util.List;

public class UserDao {
    /**
     * 用户注册
     */
    public boolean userRegister(User user) {
        String sql = "insert into t_user (user_name, password) values(?,?)";
        return CommonUtil.modify(sql,user.getUserName(),user.getPassword());
    }

    /**
     * 删除用户
     */
    public boolean userDelete(Integer userId) {
        String sql="delete from t_user where user_id=?";
        return CommonUtil.modify(sql,userId);
    }

    /**
     * 修改密码
     */
    public boolean updatePassword(String name,String oldPassword,String newPassword) {
        String sql="update t_user set password=? where user_name=? and password=?";
        return CommonUtil.modify(sql,newPassword,name,oldPassword);
    }

    /**
     * 获取所有用户信息
     */
    public List<User> selectAllUsers() {
        String sql="select * from t_user";
        return CommonUtil.query(sql,User.class,null);
    }


    /**
     * 根据ID获取用户信息
     */
    public List<User> selectById(Integer userId) {
        String sql="select * from t_user where user_id=?";
        return CommonUtil.query(sql,User.class,userId);
    }


    /**
     * 用户登录
     */
    public List<User> userLogin(String userName, String password) {
        String sql="select * from t_user where user_name=? and password=?";
        return CommonUtil.query(sql,User.class,userName,password);
    }

    /**
     * 检查该用户名是否可用
     */
    public List<User> checkUserName(String userName) {
        String sql="select * from t_user where user_name=?";
        return CommonUtil.query(sql,User.class,userName);
    }
}
