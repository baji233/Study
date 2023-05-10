package com.jiuyun.servlet;

import com.jiuyun.bean.CarItemBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class RemoveShoppingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        Integer id= Integer.valueOf(req.getParameter("id"));
        HttpSession session=req.getSession();
        Map<Integer, CarItemBean> shoppingCar=(Map<Integer, CarItemBean>) session.getAttribute("shoppingCar");
        if(shoppingCar!=null){
            shoppingCar.remove(id);
            session.setAttribute("shoppingCar",shoppingCar);
        }
        resp.sendRedirect("shoppingCarPage.jsp");
    }
}







































