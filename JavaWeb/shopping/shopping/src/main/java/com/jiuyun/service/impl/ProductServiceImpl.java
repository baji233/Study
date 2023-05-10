package com.jiuyun.service.impl;

import com.jiuyun.bean.Product;
import com.jiuyun.dao.ProductDAO;
import com.jiuyun.service.ProductService;

import java.util.List;

/**
 * @author cj
 * @create 2022年10月15日 15:40:19
 */
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Override
    public boolean save(Product product) {
        productDAO = new ProductDAO();
        return productDAO.save(product);
    }

    @Override
    public boolean delete(Integer productId) {
        productDAO = new ProductDAO();
        return productDAO.delete(productId);
    }

    @Override
    public boolean update(Product product) {
        productDAO = new ProductDAO();
        return productDAO.update(product);
    }

    @Override
    public Product selectById(Integer productId) {
        productDAO = new ProductDAO();
        return productDAO.selectById(productId);
    }

    @Override
    public List<Product> selectAll() {
        productDAO = new ProductDAO();
        return productDAO.selectAll();
    }

    @Override
    public List<Product> searchByParams(Product params) {
        productDAO = new ProductDAO();
        return productDAO.searchByParams(params);
    }
}
