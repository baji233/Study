<%@ page import="com.jiuyun.bean.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2022/10/14
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <h2>商品列表</h2>
        <table border="1px">
            <thead>
                <tr>
                    <th>商品编号</th>
                    <th>商品名称</th>
                    <th>商品类型</th>
                    <th>商品价格</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Product> productList = (List<Product>) request.getAttribute("productList");
                    for (Product product : productList) {
                        out.print("<tr>");
                        out.print("<td>" + product.getId() + "</td>");
                        out.print("<td>" + product.getName() + "</td>");
                        out.print("<td>" + product.getType() + "</td>");
                        out.print("<td>" + product.getPrice() + "</td>");
                        out.print("<td><a href='addShoppingCar?id=" + product.getId() + "'>加入购物车</a></td>");
                        out.print("</tr>");
                    }
                %>
            </tbody>
        </table>
        <a href="shoppingCarPage.jsp">我的购物车</a>
    </center>
</body>
</html>
