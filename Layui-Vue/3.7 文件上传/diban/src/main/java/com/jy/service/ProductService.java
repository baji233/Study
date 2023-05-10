package com.jy.service;

import com.jy.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    public Map findByPage(Integer page, Integer count);
    public int deleteById(Integer productid);
    public int add(Product p);
}
