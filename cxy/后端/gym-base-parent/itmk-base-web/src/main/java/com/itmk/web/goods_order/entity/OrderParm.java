package com.itmk.web.goods_order.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
public class OrderParm {
    private Long userId;
    private List<OrderItem> orderList;
}
