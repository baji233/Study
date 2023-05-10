package com.jiuyun.servlet;

import com.jiuyun.bean.Product;
import com.jiuyun.service.ProductServiceImpl;
import com.jiuyun.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductListServlet extends HttpServlet {
    //面向接口编程
    private ProductService productService=new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        List<Product> productList=productService.selectAll();
        //将查询到的结果存入request的属性，带至前台页面
        req.setAttribute("productList",productList);
        //转发productList.jsp页面展示
        req.getRequestDispatcher("productList.jsp ").forward(req,resp);
    }
}












