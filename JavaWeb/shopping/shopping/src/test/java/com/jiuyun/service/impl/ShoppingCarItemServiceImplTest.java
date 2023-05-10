package com.jiuyun.service.impl;

import com.jiuyun.bean.ShoppingCarItem;
import com.jiuyun.service.ShoppingCarItemService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年10月15日 19:32:48
 */
public class ShoppingCarItemServiceImplTest {
    private ShoppingCarItemService shoppingCarItemService;

    @Before
    public void before() {
        shoppingCarItemService = new ShoppingCarItemServiceImpl();
    }

    @Test
    public void save() {
        assertTrue(shoppingCarItemService.save(new ShoppingCarItem(1,1,2)));
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void selectAllByUserId() {
        assertTrue(shoppingCarItemService.selectAllByUserId(1).size() > 0);
    }
}