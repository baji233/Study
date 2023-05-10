package com.jiuyun.service;

import com.jiuyun.bean.User;

/**
 * @author cj
 * @create 2022年11月25日 19:30:49
 */
public interface UserService {
    User selectById(Integer userId);
}
