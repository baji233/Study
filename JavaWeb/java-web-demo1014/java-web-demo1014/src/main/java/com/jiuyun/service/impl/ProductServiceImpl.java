package com.jiuyun.service.impl;

import com.jiuyun.bean.Product;
import com.jiuyun.dao.ProductDAO;
import com.jiuyun.service.ProductService;

import java.util.List;

/**
 * @author cj
 * @create 2022年10月14日 18:52:22
 */
public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO;
    @Override
    public List<Product> selectAll() {
        productDAO = new ProductDAO();
        return productDAO.selectAll();
    }

    @Override
    public Product selectById(Integer id) {
        productDAO = new ProductDAO();
        return productDAO.selectById(id);
    }
}
