<%--
  Created by IntelliJ IDEA.
  User: 29490
  Date: 2022/10/21
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/hello" method="post">
    <table>
        <tr>
            名称：<td><input type="text" name="name"/></td>
            密码：<td><input type="text" name="password"/></td>
            <input type="submit" value="登录"/>
        </tr>
    </table>
</form>
</body>
</html>
