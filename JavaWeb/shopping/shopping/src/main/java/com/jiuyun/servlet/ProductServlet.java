package com.jiuyun.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiuyun.bean.Product;
import com.jiuyun.bean.Type;
import com.jiuyun.service.ProductService;
import com.jiuyun.service.TypeService;
import com.jiuyun.service.impl.ProductServiceImpl;
import com.jiuyun.service.impl.TypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author cj
 * @create 2022年10月16日 09:14:34
 */
public class ProductServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ProductServlet.class);
    private TypeService typeService;
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    private void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        String method = path.substring(path.lastIndexOf("/") + 1);
        switch (method) {
            case "searchByParams":
                searchByParams(request, response);
                break;
            case "productDetail":
                productDetail(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "allTypes":
                allTypes(request, response);
                break;
            default:
        }
    }

    private void allTypes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        typeService = new TypeServiceImpl();
        List<Type> typeList = typeService.selectAll();
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(JSON.toJSONString(typeList));
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        String strPrice = request.getParameter("price");
        Double price = null;
        if(strPrice != null && strPrice.trim().length() != 0) {
            price = Double.valueOf(strPrice.trim());
        }
        String strTypeId = request.getParameter("typeId");
        Integer typeId = null;
        if(strTypeId != null && strTypeId.trim().length() != 0) {
            typeId = Integer.valueOf(strTypeId);
        }
        Product product = new Product(null, productName, typeId, description, price, null, null, null);
        productService = new ProductServiceImpl();
        List<Product> productList = productService.searchByParams(product);
        typeService = new TypeServiceImpl();
        List<Type> typeList = typeService.selectAll();
        Map typeMap = listToMap(typeList);
        Map result = new HashMap();
        result.put("productList", productList);
        result.put("allTypes", typeMap);
        log.debug("result:" + JSON.toJSONString(result));
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(result));
        out.flush();
    }

    private void productDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer productId = Integer.parseInt(request.getParameter("productId").trim());
        Product product = productService.selectById(productId);
        request.setAttribute("product", product);
        request.getRequestDispatcher("/homepage/productDetail.jsp").forward(request, response);
    }

    /**
     * 首页的查询方法
     * @param request
     * @param response
     */
    private void searchByParams(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        String strPrice = request.getParameter("price");
        Double price = null;
        if(strPrice != null && strPrice.trim().length() != 0) {
            price = Double.valueOf(strPrice.trim());
        }
        String strTypeId = request.getParameter("typeId");
        Integer typeId = null;
        if(strTypeId != null && strTypeId.trim().length() != 0) {
            typeId = Integer.valueOf(strTypeId);
        }
        Product product = new Product(null, productName, typeId, description, price, null, null, null);
        productService = new ProductServiceImpl();
        List<Product> productList = productService.searchByParams(product);
        request.setAttribute("productList", productList);
        typeService = new TypeServiceImpl();
        List<Type> typeList = typeService.selectAll();
        Map typeMap = listToMap(typeList);
        request.setAttribute("typeMap", typeMap);
//        response.sendRedirect(request.getContextPath() + "/homepage/productList.jsp");
        request.getRequestDispatcher("/homepage/productList.jsp").forward(request, response);
    }

    private Map listToMap(List<Type> typeList) {
        Map map = new HashMap();
        for (Type type : typeList) {
            map.put(type.getTypeId() + "", type.getTypeName());
        }
        return map;
    }
}
