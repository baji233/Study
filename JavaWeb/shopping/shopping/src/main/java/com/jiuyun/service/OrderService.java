package com.jiuyun.service;

import com.jiuyun.bean.Order;
import com.jiuyun.bean.OrderItem;

import java.sql.SQLException;
import java.util.List;

/**
 * @author cj
 * @create 2022年10月15日 18:21:06
 */
public interface OrderService {
    boolean save(Order order);
    boolean delete(String orderId);
    boolean update(Order order);
    Order selectById(String orderId);
    List<Order> selectAll();
    boolean saveOrder(Order order, List<OrderItem> orderItemList) throws SQLException;
}
