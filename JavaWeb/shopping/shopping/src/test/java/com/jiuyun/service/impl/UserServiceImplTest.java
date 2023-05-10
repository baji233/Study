package com.jiuyun.service.impl;

import com.jiuyun.bean.User;
import com.jiuyun.service.UserService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年10月15日 19:02:44
 */
public class UserServiceImplTest {
    private UserService userService;

    @Before
    public void before() {
        userService = new UserServiceImpl();
    }

    @Test
    public void save() {
        assertTrue(userService.save(new User(null, "admin","123", "超级管理员")));
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void selectById() {
        assertNotNull(userService.selectById(1));
    }

    @Test
    public void login() {
        assertNotNull(userService.login("admin", "123"));
    }

    @Test
    public void selectAll() {
    }
}