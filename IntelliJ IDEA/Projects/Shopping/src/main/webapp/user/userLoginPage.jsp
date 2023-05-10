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
    <title>登录</title>
</head>
<script src="../bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<script src="../JQuery-1.11.1/jquery-1.11.1.min.js"></script>
<script src="../bootstrap-3.4.1-dist/css/bootstrap.min.css"></script>
<script type="text/javascript">
$(function (){

});

</script>
<body>
<center>
    <h1>登录页面</h1>
    <br>
    <form action="<%=request.getContextPath()%>/User/login" method="post" >
        <label>
            名称:
            <input type="text" name="userName">
        </label>
        <br>
        <label>
            密码:
            <input type="password" name="password">
        </label>
        <br>
        <input type="submit" value="登录">
        <a href="<%=request.getContextPath()%>/user/userRegisterPage.html">注册</a>
    </form>
</center>
</body>
</html>
