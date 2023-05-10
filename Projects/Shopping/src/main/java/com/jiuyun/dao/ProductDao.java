package com.jiuyun.dao;

import com.jiuyun.bean.Product;
import com.jiuyun.util.CommonUtil;

import java.util.List;

public class ProductDao {

    /**
     * 添加商品
     */
    public boolean productAdd(Product product) {
        String sql = "insert into t_product (product_name,type_id,description,price,picture,remark) values(?,?,?,?,?,?)";
        return CommonUtil.modify(sql,product.getProductName(),product.getTypeId(),product.getDescription(),product.getPrice(),product.getPicture(),product.getRemark());
    }

    /**
     * 删除商品
     */
    public boolean productDelete(Integer productId) {
        String sql = "update t_product set state=0 where product_id=?";
        return CommonUtil.modify(sql,productId);
    }

    /**
     * 根据商品id修改商品
     */
    public boolean productUpdate(Product product) {
        String sql = "update t_product set product_name=?,type_id=?,description=?,price=?,picture=?,remark=? where product_id=?";
        return CommonUtil.modify(sql,product.getProductName(),product.getTypeId(),product.getDescription(),product.getPrice(),product.getPicture(),product.getRemark(),product.getProductId());
    }

    /**
     * 根据ID获取商品信息
     */
    public List<Product> selectById(Integer productId) {
        String sql = "select * from t_product where product_id=?";
        return CommonUtil.query(sql,Product.class,productId);
    }

    /**
     * 获取所有商品信息
     */
    public List<Product> selectAll() {
        String sql = "select * from t_product";
        return CommonUtil.query(sql,Product.class,null);
    }

    /**
     * 根据商品名称以及描述搜索
     */
    public List<Product> searchByName(String name) {
        String sql = "select * from t_product where product_name like '%" + name + "%' or description like '%" +  name + "%'";
        return CommonUtil.query(sql,Product.class,null);
    }

    /**
     * 多条件获取商品信息
     */
    public List<Product> searchByParams(Product params) {
        String sql = "select * from t_product where 1=1 ";
        if(params.getProductName()!=null){
            sql+="and product_name like '%"+params.getProductName()+"%'";
        }else if(params.getDescription()!=null){
            sql+="and product_name like '%"+params.getDescription()+"%'";
        }else if(params.getPrice()!=null){
            sql+="and price >"+params.getPrice();
        }else if(params.getTypeId()!=null){
            sql+="and Type_id ="+params.getTypeId();
        }
        return CommonUtil.query(sql,Product.class,null);
    }
}
