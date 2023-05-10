package com.jiuyun.service;

import com.jiuyun.bean.Product;
import com.jiuyun.dao.ProductDAO;
import com.jiuyun.service.impl.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDAO productDAO=new ProductDAO();

    @Override
    public List<Product> selectAll() {
        return productDAO.selectAll();
    }

    @Override
    public Product selectById(Integer id) {
        return productDAO.selectById(id);
    }
}
