package com.jiuyun.bean;

public class Product {
    private Integer product_id;
    private String product_name;
    private Integer type_id;
    private String description;
    private Double price;
    private String picture;
    private Integer state;
    private String remark;

    public Product() {
    }

    public Product(Integer product_id, String product_name, Integer type_id, String description, Double price, String picture, Integer state, String remark) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.type_id = type_id;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.state = state;
        this.remark = remark;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", type_id=" + type_id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                '}';
    }
}
