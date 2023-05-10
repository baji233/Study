<%@ page import="com.jiuyun.bean.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
Created by IntelliJ IDEA.
  User: 29490
  Date: 2022/10/15
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>购物商城</h1>
    <form action="<%=request.getContextPath()%>/Product/searchByParams" method="get">
        <table>
            <tr>
                <td>商品名称:</td>
                <td><input type="text" name="productName"></td>
                <td>商品类型:</td>
                <td>
                    <select name="typeId">
                        <option value></option>
                        <%
                            Map typeMap=(Map)request.getAttribute("typeMap");
                            Set keySet=typeMap.keySet();
                            for(Object key:keySet){
                                out.print("<option value='"+key+"'>"+typeMap.get(key)+"</option>");
                            }
                        %>
                    </select>
                </td>
                <td>描述:</td>
                <td><input type="text" name="description"></td>
                <td>价格:</td>
                <td><input type="text" name="productPrice"></td>
                <td><input type="submit" value="搜索"></td>
            </tr>
        </table>
    </form>
    <h3>
        <table border="1px">
            <thead>
            <tr>
                <th>商品编号</th>
                <th>商品名称</th>
                <th>商品描述</th>
                <th>商品图片</th>
                <th>商品状态</th>
                <th>操作商品</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Product> byParamsList=(List<Product>)request.getAttribute("byParamsList");
                if(byParamsList!=null){
                    for(Product product : byParamsList){
                        out.print("<tr>");
                        out.print("<td>"+product.getProduct_id()+"</td>");
                        out.print("<td><a href='"+request.getContextPath()+"/product/productDetail?productId="+product.getProduct_id()+"'>"+product.getProduct_name()+"</a></td>");
                        out.print("<td>"+typeMap.get(product.getType_id())+"</td>");
                        out.print("<td>"+product.getDescription()+"</td>");
                        out.print("<td>"+product.getPrice()+"</td>");
                        out.print("<td>"+product.getRemark()+"</td>");
                        out.print("<td><a href='"+request.getContextPath()+"/ShoppingCar/add?productId="+product.getProduct_id()+"'>加入购物车</a></td>");
                        out.print("</tr>");
                    }
                }
            %>
            </tbody>
        </table>
        <a href="">我的购物车</a>
        <a href="">我的订单</a>
        <a href="../shoppingcar/shoppingCarPage.jsp">我的购物车</a>
    </h3>
</center>
</body>
</html>
