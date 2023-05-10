<%--
  Created by IntelliJ IDEA.
  User: 29490
  Date: 2022/10/18
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>商品详情</title>
</head>
<body>
<center>
    <h3>商品详情</h3>
    <table>
        <tr>
            <td><img src="../image/${product.picture}" width="400px" height="300px"></td>
        </tr>
        <tr>
            <td>商品名称:</td>
            <td>${product.productName}</td>
        </tr>
        <tr>
            <td>商品描述:</td>
            <td>${product.description}</td>
        </tr>
        <tr>
            <td>商品价格:</td>
            <td>${product.productPrice}</td>
        </tr>
        <tr>
            <td colspan="2">
                <a href="<%=request.getContextPath()%>../shoppingCar/add?productId=${product.productId}">加入购物车</a>
            </td>
        </tr>
    </table>
    <a href="<%=request.getContextPath()%>/Product/searchByParams">返回购物车页面</a>
</center>
</body>
</html>
