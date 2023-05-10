<%--
  Created by IntelliJ IDEA.
  User: 29490
  Date: 2022/10/15
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
  <h1>注册页面</h1>
  <h3>
    <form action="<%=request.getContextPath()%>/User/register" method="post" >
    用户名称:<input type="text" name="user_name" >
    <br>
    登录密码:<input type="password" name="password" >
    <br>
    确认密码:<input type="password" name="password" >
    <br>
    <input type="submit" value="注册">
    </form>
  </h3>
</center>

</body>
</html>
