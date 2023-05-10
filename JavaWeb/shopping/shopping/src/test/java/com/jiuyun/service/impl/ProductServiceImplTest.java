package com.jiuyun.service.impl;

import com.jiuyun.bean.Product;
import com.jiuyun.dao.ProductDAO;
import com.jiuyun.service.ProductService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年10月15日 15:51:21
 */
public class ProductServiceImplTest {
    private ProductService productService;

    //在每一个测试方法调用前将会执行该方法
    @Before
    public void before() {
        productService = new ProductServiceImpl();
    }

    @Test
    public void save() {
        //断言保存结果为真
        assertTrue(productService.save(new Product(null, "康师傅方便面", 1, "很好吃的方便面", 3.5, "", null, "顶新集团")));
    }

    @Test
    public void delete() {

    }

    @Test
    public void update() {
        assertTrue(productService.update(new Product(1, "康师傅方便面", 1, "很好吃的方便面", 2.5, "", null, "顶新集团")));
    }

    @Test
    public void selectById() {
        assertNotNull(productService.selectById(1));
    }

    @Test
    public void selectAll() {
        assertNotNull(productService.selectAll());
    }
}