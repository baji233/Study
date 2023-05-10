package com.jiuyun.dao;

import com.jiuyun.bean.User;
import com.jiuyun.util.CommonDaoUtil;

import java.util.List;

public class UserDao {
    public static boolean registerUser(String userName,String password){
        String sql="insert into t_user (user_name,password) values (?,?)";
        boolean isSuccessful= CommonDaoUtil.modify(sql,userName,password);
        return isSuccessful;
    }

    public static List<User> loginUser(String userName,String password){
        String sql="select * from t_user where user_name=? and password=?";
        List<User> userInfo= CommonDaoUtil.query(sql, User.class,userName,password);
        return userInfo;
    }

    public static boolean changePassword(String newPassword,String oldPassword,String userName){
        String sql="update t_user set password=? where password=? and user_name=?";
        boolean isSuccessful=CommonDaoUtil.modify(sql,User.class,newPassword,oldPassword,userName);
        return isSuccessful;
    }

    public static List<User> checkUserName(String userName){
        String sql="select * t_user where user_name=?";
        List<User> checkList=CommonDaoUtil.query(sql, User.class,userName);
        return checkList;
    }
}
