package com.test;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AJAXServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet()");
        resp.setCharacterEncoding("UTF-8");

//        String person1="{\"name\":\"daidai\",\"age\":\"18\",\"sex\":\"man\"}";
        String person2="{name:daidai,age:18,sex:man}";
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out=resp.getWriter();
        //将person转化为JSON字符串
        out.println(JSON.toJSONString(person2));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost()");
        PrintWriter out=resp.getWriter();
        out.print("23");
    }
}
