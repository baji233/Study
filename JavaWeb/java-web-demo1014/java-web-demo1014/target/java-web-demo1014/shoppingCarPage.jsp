<%@ page import="com.jiuyun.bean.CarItemBean" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2022/10/14
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <h2>我的购物车</h2>
        <table border="1px">
            <thead>
                <tr>
                    <th>商品编号</th>
                    <th>商品名称</th>
                    <th>商品价格</th>
                    <th>数量</th>
                    <th>总价</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Map<Integer, CarItemBean> shoppingCar = (Map<Integer, CarItemBean>) session.getAttribute("shoppingCar");
                    Set<Integer> keySet = shoppingCar.keySet();
                    for (Integer key : keySet) {
                        CarItemBean carItemBean = shoppingCar.get(key);
                        out.print("<tr>");
                        out.print("<td>" + key + "</td>");
                        out.print("<td>" + carItemBean.getProduct().getName() + "</td>");
                        out.print("<td>" + carItemBean.getProduct().getPrice() + "</td>");
                        out.print("<td>" + carItemBean.getCount() + "</td>");
                        out.print("<td>" + (carItemBean.getProduct().getPrice() * carItemBean.getCount()) + "</td>");
                        out.print("<td><a href='removeShoppingCar?id=" + key + "'>移出购物车</a></td>");
                        out.print("</tr>");
                    }
                %>
            </tbody>
        </table>
        <a href="productList">返回购物页面</a>
    </center>
</body>
</html>
