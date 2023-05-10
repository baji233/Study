package com.jiuyun.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cj
 * @create 2022年10月15日 09:34:16
 * 学员信息Servlet，处理所有的学员信息相关操作
 */
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    private void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        String path = request.getRequestURI();
        String type = path.substring(path.lastIndexOf("/") + 1);
        switch (type) {
            case "save":
                save(request, response);
                break;
            case "delete":
                delete(request, response);
            case "update":
                update(request, response);
                break;
            case "selectById":
                selectById(request, response);
                break;
            default:
                selectAll(request, response);
        }
    }

    private void selectAll(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("this is StudentServlet.selectAll() method!");
    }

    private void selectById(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("this is StudentServlet.selectById() method!");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("this is StudentServlet.delete() method!");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("this is StudentServlet.update() method!");
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("this is StudentServlet.save() method!");
    }

}
