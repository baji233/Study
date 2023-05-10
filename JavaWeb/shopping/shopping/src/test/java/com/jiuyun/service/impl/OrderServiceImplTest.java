package com.jiuyun.service.impl;

import com.jiuyun.bean.Order;
import com.jiuyun.bean.OrderItem;
import com.jiuyun.service.OrderService;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年10月15日 18:29:26
 */
public class OrderServiceImplTest {
    private OrderService orderService;

    @Before
    public void before() {
        orderService = new OrderServiceImpl();
    }

    @Test
    public void save() {
        assertTrue(orderService.save(new Order(null, 1, 35.0, "长沙",null,"")));
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
        assertTrue(orderService.update(new Order("1", 1, 38.0, "长沙",1,"")));
    }

    @Test
    public void selectById() {
        assertNotNull(orderService.selectById(""));
    }

    @Test
    public void selectAll() {
        assertTrue(orderService.selectAll().size() > 0);
    }

    @Test
    public void  saveOrder() {
        Order order = new Order("a0002",1, 1000.0,"长沙",null, "");
        List<OrderItem> orderItems = getOrderItems(order.getOrderId());
        try {
            assertTrue(orderService.saveOrder(order, orderItems));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private List<OrderItem> getOrderItems(String orderId) {
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem(orderId, 1, 1));
        orderItems.add(new OrderItem(orderId, 2, 2));
        orderItems.add(new OrderItem(orderId, 3, 1));
        orderItems.add(new OrderItem(orderId, 5, 3));
        return orderItems;
    }
}