package com.jiuyun.service.impl;

import com.jiuyun.bean.Type;
import com.jiuyun.service.TypeService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年10月15日 19:47:25
 */
public class TypeServiceImplTest {
    private TypeService typeService;

    @Before
    public void before() {
        typeService = new TypeServiceImpl();
    }

    @Test
    public void save() {
        assertTrue(typeService.save(new Type(10, "文具")));
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void selectById() {
        assertNotNull(typeService.selectById(1));
    }

    @Test
    public void selectAll() {
        assertTrue(typeService.selectAll().size() > 0);
    }
}