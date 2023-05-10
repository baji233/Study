<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2022/10/18
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.jiuyun.vo.ShoppingCarItemVO" %>
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
            Map<Integer, ShoppingCarItemVO> shoppingCar = (Map<Integer, ShoppingCarItemVO>) session.getAttribute("shoppingCar");
            Set<Integer> keySet = shoppingCar.keySet();
            for (Integer key : keySet) {
                ShoppingCarItemVO shoppingCarItemVO = shoppingCar.get(key);
                out.print("<tr>");
                out.print("<td>" + shoppingCarItemVO.getProduct().getProductId() + "</td>");
                out.print("<td>" + shoppingCarItemVO.getProduct().getProductName() + "</td>");
                out.print("<td>" + shoppingCarItemVO.getProduct().getPrice() + "</td>");
                out.print("<td>" + shoppingCarItemVO.getShoppingCarItem().getCount() + "</td>");
                out.print("<td>" + (shoppingCarItemVO.getShoppingCarItem().getCount() * shoppingCarItemVO.getProduct().getPrice())  + "</td>");
                out.print("<td><a href='" + request.getContextPath() + "/shoppingCar/remove?productId=" + key + "'>移出购物车</a></td>");
                out.print("</tr>");
            }
        %>
        </tbody>
    </table>
    <a href="<%=request.getContextPath()%>/product/searchByParams">返回购物页面</a>
    <form method="get" action="<%=request.getContextPath()%>/order/add">
        收货地址：<input type="text" name="address"/><input type="submit" value="下单">
    </form>
</center>
</body>
</html>
