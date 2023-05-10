<%@ page import="com.jiuyun.bean.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2022/10/16
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <h2>购物商城首页</h2>
        <form action="<%=request.getContextPath()%>/product/searchByParams" method="get">
            <table>
                <tr>
                    <td>商品名称：</td>
                    <td><input type="text" name="productName"></td>
                    <td>类型：</td>
                    <td>
                        <select name="typeId">
                            <option value=""></option>
                            <%
                                Map typeMap = (Map) request.getAttribute("typeMap");
                                Set keys = typeMap.keySet();
                                for(Object key : keys) {
                                    out.print("<option value='" + key + "'>" + typeMap.get(key) + "</option>");
                                }
                            %>
                        </select>
                    </td>
                    <td>描述：</td>
                    <td><input type="text" name="description"></td>
                    <td>价格：</td>
                    <td><input type="text" name="price"></td>
                    <td><input type="submit" value="搜索"></td>
                </tr>
            </table>
        </form>
        <table border="1px">
            <thead>
                <tr>
                    <th width="80px">商品编号</th>
                    <th width="160px">商品名称</th>
                    <th width="80px">商品类型</th>
                    <th width="150px">描述</th>
                    <th width="100px">价格</th>
                    <th width="180px">备注</th>
                    <th width="120px">操作</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Product> productList = (List<Product>) request.getAttribute("productList");
                    if(productList != null) {
                        for (Product product : productList) {
                            out.print("<tr>");
                            out.print("<td>" + product.getProductId() + "</td>");
                            out.print("<td><a href='" + request.getContextPath() + "/product/productDetail?productId=" + product.getProductId() + "'>" + product.getProductName() + "</a></td>");
                            out.print("<td>" + typeMap.get(product.getTypeId()) + "</td>");
                            out.print("<td>" + product.getDescription() + "</td>");
                            out.print("<td>" + product.getPrice() + "</td>");
                            out.print("<td>" + product.getRemark() + "</td>");
                            out.print("<td><a href='" + request.getContextPath() + "/shoppingCar/add?productId=" + product.getProductId() + "'>加入购物车</a></td>");
                            out.print("</tr>");
                        }
                    }
                %>
            </tbody>
        </table>
        <a href="../homepage/shoppingCarPage.jsp">我的购物车</a>
        <a href="">我的订单</a>
        <a href="">退出登录</a>
    </center>
</body>
</html>
