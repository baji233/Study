package com.jiuyun.bean;

/**
 * @author cj
 * @create 2022年10月14日 19:19:51
 * 购物项对象
 */
public class CarItemBean {
    private Product product;
    private Integer count;

    public CarItemBean() {
    }

    public CarItemBean(Product product, Integer count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CarItemBean{" +
                "product=" + product +
                ", count=" + count +
                '}';
    }
}
