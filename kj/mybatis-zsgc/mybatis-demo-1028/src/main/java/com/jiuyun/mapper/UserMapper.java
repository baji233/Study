package com.jiuyun.mapper;

import com.jiuyun.bean.User;

import java.util.List;

/**
 * @author cj
 * @create 2022年10月28日 20:10:43
 */
public interface UserMapper {
    User selectById(Integer userId);
    List<User> selectAll();
}
