package com.jiuyun.service;

import com.jiuyun.bean.Product;

import java.util.List;

/**
 * @author cj
 * @create 2022年10月15日 15:38:25
 */
public interface ProductService {
    boolean save(Product product);
    boolean delete(Integer productId);
    boolean update(Product product);
    Product selectById(Integer productId);
    List<Product> selectAll();

    /**
     * 根据参数查询商品信息
     * @param params
     * @return
     */
    List<Product> searchByParams(Product params);
}
