<%--
  Created by IntelliJ IDEA.
  User: 29490
  Date: 2022/10/16
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<center>
    <h4>改密页面</h4>
    <h3>
        <form action="<%=request.getContextPath()%>/User/change" method="post" >
            <label>
                用户名称:
                <input type="text" name="userName">
            </label>
            <br>
            <label>
                新的密码:
                <input type="password" name="newPassword">
            </label>
            <br>
            <label>
                确认密码:
                <input type="password" name="oldPassword">
            </label>
            <br>
            <input type="submit" value="修改">
        </form>
    </h3>
</center>

</body>
</html>
