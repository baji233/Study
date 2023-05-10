<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2022/10/13
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        session.removeAttribute("userName");
        Integer count = (Integer) application.getAttribute("count");
        if(count != null && count != 0) {
            application.setAttribute("count", --count);
        }
        response.sendRedirect("loginPage.jsp");
    %>
</body>
</html>
