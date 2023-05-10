package com.jiuyun.service;

import com.jiuyun.bean.Product;
import com.jiuyun.dao.ProductDao;
import com.jiuyun.service.interf.ProductService;
import com.jiuyun.servlet.ProductServlet;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    @Override
    public List<Product> selectAllProduct() {
        productDao=new ProductDao();
        List<Product> allProductList=productDao.selectAllProduct();
        return allProductList;
    }

    @Override
    public List<Product> selectById(Integer product_id) {
        productDao=new ProductDao();
        List<Product> byIdList=productDao.selectById(product_id);
        return byIdList;
    }

    @Override
    public boolean save(Product product) {
        productDao=new ProductDao();
        boolean isSuccess=productDao.save(product);
        return isSuccess;
    }

    @Override
    public boolean delete(Integer product_id) {
        productDao=new ProductDao();
        boolean isSuccess=productDao.delete(product_id);
        return isSuccess;
    }

    @Override
    public boolean update(Product product) {
        productDao=new ProductDao();
        boolean isSuccess=productDao.update(product);
        return false;
    }

    @Override
    public List<Product> searchByName(String product_name) {
        productDao=new ProductDao();
        List<Product> byNameList=productDao.searchByName(product_name);
        return byNameList;
    }

    @Override
    public List<Product> searchByParams(Product product) {
        productDao=new ProductDao();
        List<Product> byParamsList=productDao.searchByParams(product);
        return byParamsList;
    }
}
