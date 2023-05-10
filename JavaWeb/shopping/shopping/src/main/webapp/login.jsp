<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2022/10/16
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <h2>用户登录</h2>
        <form action="<%=request.getContextPath()%>/index/login" method="post">
            <table>
                <tr>
                    <td>用户名</td>
                    <td><input type="text" name="userName"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="登录"></td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
