package com.jiuyun.bean;

/**
 * @author cj
 * @create 2022年10月15日 11:31:01
 */
public class Order {
    private String orderId;
    private Integer userId;
    private Double orderPrice;
    private String address;
    private Integer state;
    private String remark;

    public Order() {
    }

    public Order(String orderId, Integer userId, Double orderPrice, String address, Integer state, String remark) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderPrice = orderPrice;
        this.address = address;
        this.state = state;
        this.remark = remark;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
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

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderPrice=" + orderPrice +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                '}';
    }
}
