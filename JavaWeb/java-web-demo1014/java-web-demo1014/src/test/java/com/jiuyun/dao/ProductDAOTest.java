package com.jiuyun.dao;

import com.jiuyun.bean.Product;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年10月14日 18:50:31
 */
public class ProductDAOTest {
    private ProductDAO productDAO;

    @Before
    public void beforeClass() {
        productDAO = new ProductDAO();
    }

    @Test
    public void selectAll() {
        System.out.println(productDAO.selectAll());
    }

    @Test
    public void selectById() {
        System.out.println(productDAO.selectById(1));
    }
}