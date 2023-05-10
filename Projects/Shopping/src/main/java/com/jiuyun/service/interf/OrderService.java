package com.jiuyun.service.interf;

import com.jiuyun.bean.Order;
import com.jiuyun.bean.OrderItem;

import java.util.List;

public interface OrderService {

    boolean orderAdd(Order order);
    boolean orderSave(Order order, List<OrderItem> orderItemList);
    boolean orderDelete(String orderId);
    boolean orderUpdate(Order order);
    List<Order> selectAll();
    List<Order> selectById(String orderId);


}
