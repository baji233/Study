package com.jiuyun.bean;

/**
 * @author cj
 * @create 2022年10月15日 11:27:40
 */
public class Product {
    private Integer productId;
    private String productName;
    private Integer typeId;
    private String description;
    private Double price;
    private String picture;
    private Integer state;
    private String remark;

    public Product() {
    }

    public Product(Integer productId, String productName, Integer typeId, String description, Double price, String picture, Integer state, String remark) {
        this.productId = productId;
        this.productName = productName;
        this.typeId = typeId;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.state = state;
        this.remark = remark;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", typeId=" + typeId +
                ", desc='" + description + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                '}';
    }
}
