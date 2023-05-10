package com.jiuyun.servlet;

import com.jiuyun.bean.ShoppingCarItem;
import com.jiuyun.bean.User;
import com.jiuyun.service.ShoppingCarItemService;
import com.jiuyun.service.UserService;
import com.jiuyun.service.impl.ShoppingCarItemServiceImpl;
import com.jiuyun.service.impl.UserServiceImpl;
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

/**
 * @author cj
 * @create 2022年10月16日 10:43:04
 */
public class IndexServlet extends HttpServlet {
    private UserService userService;
    private ShoppingCarItemService shoppingCarItemService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        String method = path.substring(path.lastIndexOf("/") + 1);
        switch (method) {
            case "login":
                login(request, response);
                break;
            case "loginOut":
                loginOut(request, response);
                break;
            case "checkUserName":
                checkUserName(request, response);
                break;
            case "updatePassword":
                updatePassword(request, response);
                break;
            default:
                register(request, response);
        }
    }

    /**
     * 验证用户名是否可用
     * @param request
     * @param response
     * @throws IOException
     */
    private void checkUserName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        userService = new UserServiceImpl();
        User user = userService.checkUserName(userName);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write((user == null) + "");
    }

    /**
     * 修改密码
     * @param request
     * @param response
     */
    private void updatePassword(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * 登出
     * @param request
     * @param response
     */
    private void loginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("shoppingCar");
        response.sendRedirect("../login.jsp");
    }

    /**
     * 注册用户
     * @param request
     * @param response
     * @throws IOException
     */
    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        userService = new UserServiceImpl();
        if(userService.save(new User(null, userName, password, "普通管理员"))) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("registerFail.jsp");
        }
    }

    /**
     * 用户登录
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        userService = new UserServiceImpl();
        User user = userService.login(userName, password);
        if(user != null) {
            request.getSession().setAttribute("user", user);
            //登录成功后加载该用户的购物车
            shoppingCarItemService = new ShoppingCarItemServiceImpl();
            Map map = new HashMap();
            List<ShoppingCarItemVO> shoppingCarItemVOList = shoppingCarItemService.selectAllByUserId(user.getUserId());
            for (ShoppingCarItemVO shoppingCarItemVO : shoppingCarItemVOList) {
                map.put(shoppingCarItemVO.getProduct().getProductId(), shoppingCarItemVO);
            }
            request.getSession().setAttribute("shoppingCar", map);
            request.getRequestDispatcher("/product/searchByParams").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
