package com.jiuyun.mapper;

import com.jiuyun.bean.User;
import com.jiuyun.util.SqlSessionUtil;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年10月28日 20:13:23
 */
public class UserMapperTest {
    private static final Logger log = LoggerFactory.getLogger(UserMapperTest.class);
    private UserMapper userMapper;
    @Before
    public void before() {
        userMapper = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class);
    }

    @Test
    public void selectById() {
        User user = userMapper.selectById(1);
        log.info("查询结果：" + user);
    }

    @Test
    public void selectAll() {
        List<User> userList = userMapper.selectAll();
        log.info("查询结果：" + userList);
    }
}