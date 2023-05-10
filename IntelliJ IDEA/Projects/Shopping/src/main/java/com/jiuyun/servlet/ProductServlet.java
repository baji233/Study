package com.jiuyun.servlet;

import com.alibaba.fastjson.JSON;
import com.jiuyun.bean.Product;
import com.jiuyun.bean.Type;
import com.jiuyun.service.ProductServiceImpl;
import com.jiuyun.service.TypeServiceImpl;
import com.jiuyun.service.interf.ProductService;
import com.jiuyun.service.interf.TypeService;
import com.jiuyun.util.CommonDaoUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServlet extends HttpServlet {
    private ProductService productService;
    private TypeService typeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    private void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=CommonDaoUtil.getSubURL(req);
        switch (method){
            case "searchByParams":
                searchByParams(req, resp);
                break;
            case "productDetail":
                productDetail(req, resp);
            case "search":
                search(req,resp);
        }
    }

    /**
     * 商品详情
     */
    private void productDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer productId=Integer.parseInt(req.getParameter("productId").trim());
        List<Product> byIdList=productService.selectById(productId);
        req.setAttribute("byIdList",byIdList);
        req.getRequestDispatcher("product/productDetail").forward(req,resp);
    }

    /**
     * 商品首页的多条件搜索(商品名称，商品描述，商品价格，商品类型ID);
     * 所有商品展示。
     * @param req
     * @param resp
     */
    private void searchByParams(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName=req.getParameter("productName");
        String description=req.getParameter("description");
        String stringPrice=req.getParameter("productPrice");
        String stringTypeId=req.getParameter("typeId");
        //转型
        Double price=null;
        if(stringPrice!=null && stringPrice.trim().length()!=0){
            price=Double.valueOf(stringPrice.trim());
        }
        Integer typeId=null;
        if(stringTypeId!=null && stringTypeId.trim().length()!=0){
            typeId=Integer.valueOf(stringTypeId.trim());
        }
        //多条件搜索
        Product product=new Product(null,productName,typeId,description,price,null,null,null);
        productService=new ProductServiceImpl();
        List<Product> byParamsList=productService.searchByParams(product);
        req.setAttribute("byParamsList",byParamsList);
        //查询全部商品,然后List转Map
        typeService=new TypeServiceImpl();
        List<Type> allType=typeService.selectAll();
        Map typeMap=new HashMap();
        for(Type type : allType){
            typeMap.put(type.getType_id(),type.getType_name());
        }
        req.setAttribute("typeMap",typeMap);
        req.getRequestDispatcher("/product/productList.html").forward(req,resp);
    }

    /**
     * 商品首页的多条件搜索，List-->JSON
     * @param req
     * @param resp
     * @throws IOException
     */
    private void search(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String productName=req.getParameter("productName");
        String description=req.getParameter("description");
        String stringPrice=req.getParameter("productPrice");
        String stringTypeId=req.getParameter("typeId");
        //转型
        Double price=null;
        if(stringPrice!=null && stringPrice.trim().length()!=0){
            price=Double.valueOf(stringPrice.trim());
        }
        Integer typeId=null;
        if(stringTypeId!=null && stringTypeId.trim().length()!=0){
            typeId=Integer.valueOf(stringTypeId.trim());
        }
        //多条件搜索（如果参数为空，就返回所有商品）
        Product product=new Product(null,productName,typeId,description,price,null,null,null);
        productService=new ProductServiceImpl();
        List<Product> byParamsList=productService.searchByParams(product);
        //test
        if(byParamsList!=null){
            System.out.println(byParamsList);
        }else if(byParamsList==null){
            System.out.println("Fail");
        }
        //商品类型选择框
        typeService=new TypeServiceImpl();
        List<Type> allType=typeService.selectAll();
        Map typeMap=new HashMap();
        for(Type type : allType){
            typeMap.put(type.getType_id(),type.getType_name());
        }
        //转化为JSON字符串
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println(byParamsList);//输出到前端
        out.println(typeMap);


    }
}



















