<%--
  Created by IntelliJ IDEA.
  User: 29490
  Date: 2022/10/14
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.jiuyun.bean.Product"%>
<%@ page import="java.util.List"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h3>商品列表</h3>
    <h2>
        <table border="1px">
            <thead>
            <tr>
                <th>商品编号</th>
                <th>商品名字</th>
                <th>商品类型</th>
                <th>商品单价</th>
                <th>操作商品</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Product>productList=(List<Product>)request.getAttribute("productList");
                for(Product product:productList){
                    out.print("<tr>");
                    out.print("<td>"+product.getId()+"</td>");
                    out.print("<td>"+product.getName()+"</td>");
                    out.print("<td>"+product.getType()+"</td>");
                    out.print("<td>"+product.getPrice()+"</td>");
                    out.print("<td><a href='addShoppingCar?id="+product.getId()+"'>加入购物车</a></td>");
                    out.print("<tr>");
                }
            %>
            </tbody>
        </table>
        <a href="shoppingCarPage.jsp">我的购物车</a>
    </h2>
</center>
</body>
</html>
































