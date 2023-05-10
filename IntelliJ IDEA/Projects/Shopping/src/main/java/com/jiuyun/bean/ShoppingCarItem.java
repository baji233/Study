package com.jiuyun.bean;

public class ShoppingCarItem {
    private Integer user_id;
    private Integer product_id;
    private Integer count;

    public ShoppingCarItem() {
    }

    public ShoppingCarItem(Integer user_id, Integer product_id, Integer count) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.count = count;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ShoppingCar{" +
                "user_id=" + user_id +
                ", product_id=" + product_id +
                ", count=" + count +
                '}';
    }
}
