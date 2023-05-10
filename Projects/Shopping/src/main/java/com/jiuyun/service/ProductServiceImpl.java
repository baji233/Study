package com.jiuyun.service;

import com.jiuyun.bean.Product;
import com.jiuyun.dao.ProductDao;
import com.jiuyun.service.interf.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductDao productDao = new ProductDao();

    @Override
    public boolean productAdd(Product product) {
        return productDao.productAdd(product);
    }

    @Override
    public boolean productDelete(Integer productId) {
        return productDao.productDelete(productId);
    }

    @Override
    public boolean productUpdate(Product product) {
        return productDao.productUpdate(product);
    }

    @Override
    public List<Product> selectById(Integer productId) {
        return productDao.selectById(productId);
    }

    @Override
    public List<Product> selectAll() {
        return productDao.selectAll();
    }

    @Override
    public List<Product> searchByName(String name) {
        return productDao.searchByName(name);
    }

    @Override
    public List<Product> searchByParams(Product params) {
        return productDao.searchByParams(params);
    }
}
