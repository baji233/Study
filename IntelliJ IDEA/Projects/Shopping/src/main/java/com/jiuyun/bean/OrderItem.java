package com.jiuyun.bean;

public class OrderItem {
    private String order_id;
    private Integer product_id;
    private Integer product_count;

    public OrderItem() {
    }

    public OrderItem(String order_id, Integer product_id, Integer product_count) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.product_count = product_count;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getProduct_count() {
        return product_count;
    }

    public void setProduct_count(Integer product_count) {
        this.product_count = product_count;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "order_id=" + order_id +
                ", product_id=" + product_id +
                ", product_count=" + product_count +
                '}';
    }
}
