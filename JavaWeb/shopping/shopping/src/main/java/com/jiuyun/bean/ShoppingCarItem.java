package com.jiuyun.bean;

/**
 * @author cj
 * @create 2022年10月15日 11:33:06
 */
public class ShoppingCarItem {
    private Integer userId;
    private Integer productId;
    private Integer count;

    public ShoppingCarItem() {
    }

    public ShoppingCarItem(Integer userId, Integer productId, Integer count) {
        this.userId = userId;
        this.productId = productId;
        this.count = count;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        return "ShoppingCarItem{" +
                "userId=" + userId +
                ", productId=" + productId +
                ", count=" + count +
                '}';
    }
}
