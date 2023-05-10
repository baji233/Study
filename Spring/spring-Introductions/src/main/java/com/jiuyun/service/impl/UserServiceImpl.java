package com.jiuyun.service.impl;

import com.jiuyun.dao.UserDAO;
import com.jiuyun.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cj
 * @create 2022年11月23日 19:30:52
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;

    public void save() {
        userDAO.save();
    }

    public void update() {
        userDAO.update();
    }
}
