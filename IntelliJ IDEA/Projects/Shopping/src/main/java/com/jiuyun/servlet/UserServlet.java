package com.jiuyun.servlet;

import com.jiuyun.bean.ShoppingCarItem;
import com.jiuyun.bean.User;
import com.jiuyun.service.ShoppingCarItemServiceImpl;
import com.jiuyun.service.UserServiceImpl;
import com.jiuyun.service.interf.ShoppingCarItemService;
import com.jiuyun.service.interf.UserService;
import com.jiuyun.util.CommonDaoUtil;
import com.jiuyun.vo.ShoppingCarItemVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServlet extends HttpServlet {
    UserService us = new UserServiceImpl();
    ShoppingCarItemService scis = new ShoppingCarItemServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    /**
     * 一个servlet实现用户登录和注册
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String type = CommonDaoUtil.getSubURL(req);
        switch (type){
            case "checkUserName":
                checkUserName(req,resp);
                break;

            case "login":
                login(req, resp);
                break;

            case "register":
                register(req, resp);
                break;

            case "change":
                change(req, resp);
                break;

            default:
                //
        }
    }

    /**
     * 检查用户名可用
     * @param req
     * @param resp
     * @return
     */
    private void checkUserName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName=req.getParameter("userName");
        List<User> userList=us.checkUserName(userName);
        boolean b = false;
        if(userList != null) { b = true; }//如果结果集不为空，表示此用户名已被占用
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter=resp.getWriter();
        printWriter.write(b+"");
    }

    /**
     * 用户登录
     * @param req
     * @param resp
     */
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName= String.valueOf(req.getParameter("userName"));
        String password=String.valueOf(req.getParameter("password"));
        List<User> userList=us.loginUser(userName,password);
        if(userList.size() !=0){
            //登录成功后加载该用户的购物车
            req.getSession().setAttribute("userList",userList);
            Map map=new HashMap();
            User user=userList.get(0);
            List<ShoppingCarItemVO> scivoList=scis.selectAllById(user.getUser_id());
            ShoppingCarItemVO scivoscivo=scivoList.get(0);
            map.put(scivoscivo.getProduct().getProduct_id(),scivoscivo);
            req.getSession().setAttribute("shoppingCar",map);
            req.getRequestDispatcher("/shoppingCar/shoppingCarPage.jsp");
        }else{
            resp.sendRedirect("/user/userLoginPage.jsp");
        }
    }

    /**
     * 用户注册
     * @param req
     * @param resp
     */
    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName1  = String.valueOf(req.getParameter("userName"));
        String password1 = String.valueOf(req.getParameter("password1"));
        boolean isSuccess=us.registerUser(userName1,password1);
        if(isSuccess){
            //注册成功就重定向登录页面
            resp.sendRedirect("/user/userLoginPage.jsp");
        }else{
            resp.sendRedirect("/user/userRegisterPage.html");
        }
    }

    /**
     * 修改密码
     * @param req
     * @param resp
     */
    private void change(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String newPassword2=String.valueOf(req.getParameter("newPassword"));
        String oldPassword2=String.valueOf(req.getParameter("oldPassword"));
        String userName2=String.valueOf(req.getParameter("userName"));
        boolean isSuccess=us.changePassword(newPassword2,oldPassword2,userName2);
        if(isSuccess){
            req.getRequestDispatcher("/product/productList.html").forward(req,resp);
        }else{
            resp.sendRedirect("/user/userChangePassPage.jsp");
        }
    }
}























