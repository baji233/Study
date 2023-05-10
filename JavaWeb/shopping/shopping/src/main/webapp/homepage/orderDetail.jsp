<%@ page import="com.jiuyun.bean.Order" %>
<%@ page import="com.jiuyun.bean.OrderItem" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2022/10/18
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
    <h3>订单结算</h3>
    <table width="500px">
        <tr>
            <td>订单编号：</td>
            <td>${order.orderId}</td>
            <td>订单价格：</td>
            <td>${order.orderPrice}</td>
        </tr>
        <tr>
            <td>订单状态：</td>
            <td>
                <%
                    Order order = (Order) request.getAttribute("order");
                    switch (order.getState()) {
                        case 0:
                            out.print("失效");
                            break;
                        case 1:
                            out.print("待支付");
                            break;
                        default:
                            out.print("已支付");
                    }
                %>
            </td>
            <td>地址：</td>
            <td>${order.address}</td>
        </tr>
    </table>
    <table border="1px">
        <thead>
            <tr>
                <th>序号</th>
                <th>商品编号</th>
                <th>数量</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<OrderItem> orderItemList = (List<OrderItem>) request.getAttribute("orderItemList");
                for (int i = 0; i < orderItemList.size(); i++) {
                    out.print("<tr>");
                    out.print("<td>" + (i + 1) + "</td>");
                    out.print("<td>" + orderItemList.get(i).getProductId() + "</td>");
                    out.print("<td>" + orderItemList.get(i).getCount() + "</td>");
                    out.print("</tr>");
                }
            %>
        </tbody>
    </table>
    </center>
</body>
</html>
