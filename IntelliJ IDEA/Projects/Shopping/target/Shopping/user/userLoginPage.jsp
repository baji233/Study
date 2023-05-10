<%--
  Created by IntelliJ IDEA.
  User: 29490
  Date: 2022/10/15
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>登录页面</h1>
    <br>
    <form action="<%=request.getContextPath()%>/User/login" method="post" >
        名称:<input type="text" name="user_name" >
        <br>
        密码:<input type="password" name="password" >
        <br>
        <input type="submit" value="登录">
        <a href="<%=request.getContextPath()%>/user/userRegisterPage.jsp">注册</a>
    </form>
</center>
</body>
</html>
