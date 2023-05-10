package com.jiuyun.service.interf;

import com.jiuyun.bean.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有商品信息
     * @return 查询结果集
     */
    List<Product> selectAllProduct();

    /**
     * 根据商品ID获取商品信息
     * @param product_id
     * @return
     */
    List<Product> selectById(Integer product_id);

    /**
     * 保存商品信息
     * @param product
     * @return
     */
    boolean save(Product product);

    /**
     * 根据商品ID删除商品
     * @param product_id
     * @return
     */
    boolean delete(Integer product_id);

    /**
     * 根据商品ID修改商品
     * @param product
     * @return
     */
    boolean update(Product product);

    /**
     * 根据商品名称以及商品描述搜索商品
     * @param product_name
     * @return
     */
    List<Product> searchByName(String product_name);

    /**
     * 多种条件搜索商品
     * @param product
     * @return
     */
    List<Product> searchByParams(Product product);
}










