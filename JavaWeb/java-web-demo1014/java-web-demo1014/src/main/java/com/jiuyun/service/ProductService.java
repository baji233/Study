package com.jiuyun.service;

import com.jiuyun.bean.Product;

import java.util.List;

/**
 * @author cj
 * @create 2022年10月14日 18:51:48
 */
public interface ProductService {
    List<Product> selectAll();
    Product selectById(Integer id);
}
