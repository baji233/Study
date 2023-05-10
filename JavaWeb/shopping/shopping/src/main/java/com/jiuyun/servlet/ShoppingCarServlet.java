package com.jiuyun.servlet;

import com.jiuyun.bean.ShoppingCarItem;
import com.jiuyun.bean.Product;
import com.jiuyun.bean.User;
import com.jiuyun.service.ProductService;
import com.jiuyun.service.ShoppingCarItemService;
import com.jiuyun.service.impl.ProductServiceImpl;
import com.jiuyun.service.impl.ShoppingCarItemServiceImpl;
import com.jiuyun.vo.ShoppingCarItemVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class ShoppingCarServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ShoppingCarServlet.class);
    private ProductService productService;
    private ShoppingCarItemService shoppingCarItemService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        String method = path.substring(path.lastIndexOf("/") + 1);
        switch (method) {
            case "add":
                add(request, response);
                break;
            case "remove":
                remove(request, response);
                break;
            default:
                log.warn("路径有误");
        }
    }

    /**
     * 想购物车中添加购物项的方法
     * @param request
     * @param response
     * @throws IOException
     */
    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        productService = new ProductServiceImpl();
        shoppingCarItemService = new ShoppingCarItemServiceImpl();
        //此处最好要做非空判断
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        //从session中获取购物车对象
        Map<Integer, ShoppingCarItemVO> shoppingCar = (Map) session.getAttribute("shoppingCar");
        ShoppingCarItemVO shoppingCarItemVO = null;
        //判断购物车中是否包含该商品
        if(shoppingCar.containsKey(productId)) {
            shoppingCarItemVO = shoppingCar.get(productId);
            shoppingCarItemVO.getShoppingCarItem().setCount(shoppingCarItemVO.getShoppingCarItem().getCount() + 1);
            shoppingCarItemService.update(shoppingCarItemVO.getShoppingCarItem());
        } else {
            ShoppingCarItem shoppingCarItem = new ShoppingCarItem(user.getUserId(), productId, 1);
            shoppingCarItemService.save(shoppingCarItem);
            shoppingCarItemVO = new ShoppingCarItemVO(shoppingCarItem, productService.selectById(productId));
        }
        shoppingCar.put(productId, shoppingCarItemVO);
        session.setAttribute("shoppingCar", shoppingCar);
        response.sendRedirect("../homepage/shoppingCarPage.jsp");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Map<Integer, ShoppingCarItemVO> shoppingCar = (Map<Integer, ShoppingCarItemVO>) session.getAttribute("shoppingCar");
        if(shoppingCar != null) {
            shoppingCar.remove(productId);
            shoppingCarItemService.delete(user.getUserId(), productId);
            session.setAttribute("shoppingCar", shoppingCar);
        }
        response.sendRedirect("../homepage/shoppingCarPage.jsp");
    }

}
