package com.jiuyun.servlet;

import com.jiuyun.bean.CarItemBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author cj
 * @create 2022年10月14日 19:40:40
 * 将所选的购物项从购物车中移出
 */
public class RemoveShoppingCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        Map<Integer, CarItemBean> shoppingCar = (Map<Integer, CarItemBean>) session.getAttribute("shoppingCar");
        if(shoppingCar != null) {
            shoppingCar.remove(id);
            session.setAttribute("shoppingCar", shoppingCar);
        }
        response.sendRedirect("shoppingCarPage.jsp");
    }
}



























