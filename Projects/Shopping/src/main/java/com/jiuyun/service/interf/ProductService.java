package com.jiuyun.service.interf;

import com.jiuyun.bean.Product;

import java.util.List;

public interface ProductService {

    boolean productAdd(Product product);
    boolean productDelete(Integer productId);
    boolean productUpdate(Product product);
    List<Product> selectById(Integer productId);
    List<Product> selectAll();
    List<Product> searchByName(String name);
    List<Product> searchByParams(Product params);

}
