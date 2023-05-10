package com.jiuyun.demo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Demo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if("dd".equals(name) && "123".equals(password)){
            Map map = new HashMap();
            map.put(name,password);
            req.getSession().setAttribute("user",map);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }else{
            resp.sendRedirect(req.getContextPath() + "/demo/demo3.jsp");
        }
    }









    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            //如果cookies不为空，就使用cookie中的用户名和密码进行自动登录
            String cName1 = null;
            String cPassword = null;
            for(int i=0;i<=cookies.length;i++){
                Cookie cookie=cookies[i];
                String cName2 = cookie.getName();
                String cValue = cookie.getValue();
                if("name".equals(cName2)){
                    cName1 = cValue;
                }
                if("password".equals(cName2)){
                    cPassword = cValue;
                }
            }

        } else {
            if (name.equals("tjw") && password.equals("123")) {
                Cookie cookie1 = new Cookie("name", name);
                Cookie cookie2 = new Cookie("password", password);
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);

                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("../demo/demo1.jsp");
            }
        }
    }
}
