package com.jiuyun.servlet;

import com.jiuyun.bean.CarItemBean;
import com.jiuyun.bean.Product;
import com.jiuyun.service.ProductService;
import com.jiuyun.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cj
 * @create 2022年10月14日 19:08:16
 */
public class AddShoppingCarServlet extends HttpServlet {

    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        productService = new ProductServiceImpl();
        //此处最好要做非空判断
        Integer id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.selectById(id);
        Map<Integer, CarItemBean> shoppingCar = (Map) session.getAttribute("shoppingCar");
        if(shoppingCar == null) {
            shoppingCar = new HashMap();
            shoppingCar.put(id, new CarItemBean(product, 1));
        } else {
            if(shoppingCar.containsKey(id)) {
                CarItemBean carItemBean = shoppingCar.get(id);
                carItemBean.setCount(carItemBean.getCount() + 1);
                shoppingCar.put(id, carItemBean);
            } else {
                shoppingCar.put(id, new CarItemBean(product, 1));
            }
        }
        session.setAttribute("shoppingCar", shoppingCar);
        response.sendRedirect("shoppingCarPage.jsp");
    }
}

















