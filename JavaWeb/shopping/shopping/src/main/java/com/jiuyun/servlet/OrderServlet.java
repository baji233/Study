package com.jiuyun.servlet;

import com.jiuyun.bean.Order;
import com.jiuyun.bean.OrderItem;
import com.jiuyun.bean.User;
import com.jiuyun.dao.OrderDAO;
import com.jiuyun.service.OrderService;
import com.jiuyun.service.ShoppingCarItemService;
import com.jiuyun.service.impl.OrderServiceImpl;
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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * @author cj
 * @create 2022年10月18日 18:07:34
 */
public class OrderServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(OrderServlet.class);

    private OrderService orderService;
    private ShoppingCarItemService shoppingCarItemService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    private void doService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getRequestURI();
        String method = path.substring(path.lastIndexOf("/") + 1);
        switch (method) {
            case "add":
                add(request, response);
                break;
            case "update":
                update(request, response);
            case "delete":
                delete(request, response);
            default:
                log.warn("路径错误！");
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        orderService = new OrderServiceImpl();
        shoppingCarItemService = new ShoppingCarItemServiceImpl();
        HttpSession session = request.getSession();
        String orderId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String address = request.getParameter("address");
        User user = (User) session.getAttribute("user");
        List<ShoppingCarItemVO> shoppingCarItemVOS = shoppingCarItemService.selectAllByUserId(user.getUserId());
        double orderPrice = 0;
        List<OrderItem> orderItemList = new ArrayList<>();
        for (ShoppingCarItemVO vo : shoppingCarItemVOS) {
            orderPrice += (vo.getProduct().getPrice() * vo.getShoppingCarItem().getCount());
            orderItemList.add(new OrderItem(orderId, vo.getProduct().getProductId(), vo.getShoppingCarItem().getCount()));
        }
        try {
            Order order = new Order(orderId, user.getUserId(), orderPrice, address,1, "");
            orderService.saveOrder(order, orderItemList);
            shoppingCarItemService.clearShoppingCar(user.getUserId());
            request.setAttribute("order", order);
            request.setAttribute("orderItemList", orderItemList);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        request.getRequestDispatcher("/homepage/orderDetail.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    public static void main(String[] args) {
        String orderId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        System.out.println(orderId);
    }
}
