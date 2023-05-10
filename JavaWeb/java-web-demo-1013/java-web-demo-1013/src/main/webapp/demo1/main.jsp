<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2022/10/13
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //未登录用户跳转至登录页面
        String userName = (String) session.getAttribute("userName");
        if(userName == null) {
            response.sendRedirect("loginPage.jsp");
        }
    %>
    <h1>欢迎访问本网站，欢迎您，尊贵的<%=session.getAttribute("userName")%>用户</h1>
    <h3>当前在线人数为：<%=application.getAttribute("count")%></h3>
    <a href="logout.jsp">注销</a>
</body>
</html>
