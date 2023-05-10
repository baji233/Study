package com.jiuyun.bean;

public class OrderItem {
    private String orderId;
    private Integer productId;
    private Integer count;

    public OrderItem() {
    }

    public OrderItem(String orderId, Integer productId, Integer count) {
        this.orderId = orderId;
        this.productId = productId;
        this.count = count;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderId='" + orderId + '\'' +
                ", productId=" + productId +
                ", count=" + count +
                '}';
    }

}
