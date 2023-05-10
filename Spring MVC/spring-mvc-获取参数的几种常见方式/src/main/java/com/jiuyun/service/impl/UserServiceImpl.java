package com.jiuyun.service.impl;

import com.jiuyun.bean.User;
import com.jiuyun.dao.UserDAO;
import com.jiuyun.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cj
 * @create 2022年11月25日 19:31:33
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;
    @Override
    public User selectById(Integer userId) {
        return userDAO.selectById(userId);
    }
}
