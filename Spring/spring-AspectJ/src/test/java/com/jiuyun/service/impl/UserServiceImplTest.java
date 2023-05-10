package com.jiuyun.service.impl;

import com.jiuyun.bean.User;
import com.jiuyun.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年11月23日 20:35:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void save() {
        userService.save(User.builder().userId(10000).userName("admin").build());
    }

    @Test
    public void update() {
        userService.update(User.builder().userId(10000).userName("admin").build());
    }
}