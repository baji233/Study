package com.jiuyun.servlet;

import com.jiuyun.bean.CarItemBean;
import com.jiuyun.bean.Product;
import com.jiuyun.service.ProductServiceImpl;
import com.jiuyun.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AddShoppingCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        HttpSession session=req.getSession();
        ProductService productService=new ProductServiceImpl();
        Integer id=(Integer) req.getAttribute("id");
        //如果有商品id就将其放入购物车
        if(id!=null){
            Product product=productService.selectById(id);
            Map<Integer, CarItemBean> shoppingCar=(Map)session.getAttribute("shoppingCar");
            //如果没有购物车，就创建一个
            if(shoppingCar==null){
                shoppingCar=new HashMap();
                shoppingCar.put(id,new CarItemBean(product,1));//购物车的结构
                //如果s购物车已经有该商品了，数量就加一
            }else if(shoppingCar.containsKey(id)){
                CarItemBean carItemBean=shoppingCar.get("id");
                carItemBean.setCount(carItemBean.getCount()+1);
                shoppingCar.put(id,carItemBean);
            }
            //将购物车放入session
            session.setAttribute("shoppingCar",shoppingCar);
            resp.sendRedirect("shoppingCarPage.jsp");
        }else{
            //如果没商品id就重定向到空购物车页面
            resp.sendRedirect("shoppingCarIsNull.jsp");
        }
    }
}
























