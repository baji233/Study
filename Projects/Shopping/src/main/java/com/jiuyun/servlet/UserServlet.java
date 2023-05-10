package com.jiuyun.servlet;

import com.jiuyun.bean.User;
import com.jiuyun.service.UserServiceImpl;
import com.jiuyun.service.interf.UserService;
import com.jiuyun.util.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserServlet extends HttpServlet {

    /**
     * 从安全角度着想，用户操作的行为都得用Post方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    UserService userServlet = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String subURl = CommonUtil.getSubURL(req);
        switch (subURl){
            case "login":
                login(req,resp);
                break;
            case "register":
                register(req,resp);
                break;
            case "updatePassword":
                updatePassword(req,resp);
                break;
            case "loginOut":
                loginOut(req,resp);
                break;
            case "checkName":
                checkName(req,resp);
                break;
            default :
                break;
        }
    }

    /**
     * 注册时检查用户名是否被占用
     * @param req
     * @param resp
     */
    private void checkName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("userName");
        List<User> userList = userServlet.checkUserName(userName);
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        //向页面写入一个布尔值（true:占用，false:可用）
        out.write((userList == null)+"");
    }

    /**
     * 登出当前账号
     * @param req
     * @param resp
     */
    private void loginOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //移除当前用户的账号和购物车的Session,并重定向到登录页面
        req.getSession().removeAttribute("userName");
        req.getSession().removeAttribute("ShoppingCar");
        resp.sendRedirect("../user/login.jsp");
    }

    /**
     * 修改密码
     * @param req
     * @param resp
     */
    private void updatePassword(HttpServletRequest req, HttpServletResponse resp) {
        String userName = req.getParameter("userName");
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        userServlet.updatePassword(userName,oldPassword,newPassword);
        //TODO:使用AJAX的回调函数返回修改结果

    }

    /**
     * 用户注册
     * @param req
     * @param resp
     */
    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        boolean flag = userServlet.userRegister(new User(null,userName,password,null));
        if(flag){
            req.getRequestDispatcher("../user/login.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("../user/register.html");
        }
    }

    /**
     * 用户登录
     * @param req
     * @param resp
     */
    private void login(HttpServletRequest req, HttpServletResponse resp) {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        List<User> userList= userServlet.userLogin(userName,password);
        //登录成功后加载该用户的购物车
        if(userList != null){

        }else{

        }
    }
}




















