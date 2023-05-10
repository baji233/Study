package com.jiuyun.service.impl;

import com.jiuyun.bean.Product;

import java.util.List;

/**
 * 使用接口有更好的扩展性
 */
public interface ProductService {
    List<Product> selectAll();
    Product selectById(Integer id);
}
