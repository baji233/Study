package com.jiuyun.bean;

public class Order {
    private String order_id;
    private String address;
    private Integer state;
    private String remark;
    private Integer totalprice;
    private Integer user_id;

    public Order() {
    }

    public Order(String order_id, String address, Integer state, String remark, Integer totalprice, Integer user_id) {
        this.order_id = order_id;
        this.address = address;
        this.state = state;
        this.remark = remark;
        this.totalprice = totalprice;
        this.user_id = user_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                ", totalprice=" + totalprice +
                ", user_id=" + user_id +
                '}';
    }
}
