package com.jiuyun.dao;

import com.jiuyun.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @author cj
 * @create 2022年11月25日 19:29:04
 */
@Repository
public class UserDAO {
    public User selectById(Integer userId) {
        return User.builder().userId(userId).userName("admin").password("123").remark("普通管理员").build();
    }
}
