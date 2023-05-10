package com.jiuyun.service;

import com.jiuyun.bean.Order;
import com.jiuyun.bean.OrderItem;
import com.jiuyun.dao.OrderDao;
import com.jiuyun.service.interf.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDao();

    @Override
    public boolean orderAdd(Order order) {
        return orderDao.orderAdd(order);
    }

    @Override
    public boolean orderSave(Order order, List<OrderItem> orderItemList) {
        boolean isSuccess = false;
        try {
            isSuccess = orderDao.orderSave(order, orderItemList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public boolean orderDelete(String orderId) {
        return orderDao.orderDelete(orderId);
    }

    @Override
    public boolean orderUpdate(Order order) {
        return orderDao.orderUpdate(order);
    }

    @Override
    public List<Order> selectAll() {
        return orderDao.selectAll();
    }

    @Override
    public List<Order> selectById(String orderId) {
        return orderDao.selectById(orderId);
    }
}
