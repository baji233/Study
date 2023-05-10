package com.jiuyun.service.impl;

import com.jiuyun.bean.Order;
import com.jiuyun.bean.OrderItem;
import com.jiuyun.dao.OrderDAO;
import com.jiuyun.service.OrderService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author cj
 * @create 2022年10月15日 18:27:25
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    @Override
    public boolean save(Order order) {
        orderDAO = new OrderDAO();
        return orderDAO.save(order);
    }

    @Override
    public boolean delete(String orderId) {
        orderDAO = new OrderDAO();
        return orderDAO.delete(orderId);
    }

    @Override
    public boolean update(Order order) {
        orderDAO = new OrderDAO();
        return orderDAO.update(order);
    }

    @Override
    public Order selectById(String orderId) {
        orderDAO = new OrderDAO();
        return orderDAO.selectById(orderId);
    }

    @Override
    public List<Order> selectAll() {
        orderDAO = new OrderDAO();
        return orderDAO.selectAll();
    }

    @Override
    public boolean saveOrder(Order order, List<OrderItem> orderItemList) throws SQLException {
        orderDAO = new OrderDAO();
        return orderDAO.saveOrder(order, orderItemList);
    }
}
