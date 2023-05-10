package com.jiuyun.dao;

import com.jiuyun.bean.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDAO {
    public User selectById(Integer id){
        return User.builder().id(id).name("雄安谬").build();
    }
}
