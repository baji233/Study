package com.jiuyun.servlet;

import com.jiuyun.bean.Product;
import com.jiuyun.service.ProductService;
import com.jiuyun.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author cj
 * @create 2022年10月14日 18:54:52
 */
public class ProductListServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.selectAll();
        //将查询到的结果存入request，带至前台页面
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("productList.jsp").forward(request, response);
    }
}
