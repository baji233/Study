<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2022/10/13
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if(userName != null && "123".equals(password)) {
            System.out.println("登录成功！");
            session.setAttribute("userName", userName);
            Integer count = (Integer) application.getAttribute("count");
            if(count == null) {
                application.setAttribute("count", 1);
            } else {
                application.setAttribute("count", ++count);
            }
            request.getRequestDispatcher("main.jsp").forward(request, response);
        } else {
            System.out.println("登录失败，用户名或者密码错误！");
            response.sendRedirect("loginPage.jsp");
        }
    %>
</body>
</html>
