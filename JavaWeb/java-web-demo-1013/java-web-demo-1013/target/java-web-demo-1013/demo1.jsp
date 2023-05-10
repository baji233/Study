<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2022/10/13
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //应用程序
        Integer count = (Integer) application.getAttribute("count");
        if(count == null) {
            application.setAttribute("count", 1);
        } else {
            application.setAttribute("count", ++count);
        }
        //会话
        count = (Integer) session.getAttribute("count");
        if(count == null) {
            session.setAttribute("count", 1);
        } else {
            session.setAttribute("count", ++count);
        }
        //当前页面
        count = (Integer) pageContext.getAttribute("count");
        if(count == null) {
            pageContext.setAttribute("count", 1);
        } else {
            pageContext.setAttribute("count", ++count);
        }
        //当次请求
        count = (Integer) request.getAttribute("count");
        if(count == null) {
            request.setAttribute("count", 1);
        } else {
            request.setAttribute("count", ++count);
        }
    %>

    <h3>
        application:<%=application.getAttribute("count")%><br/>
        session:<%=session.getAttribute("count")%><br/>
        pageContext:<%=pageContext.getAttribute("count")%><br/>
        request:<%=request.getAttribute("count")%><br/>
    </h3>
</body>
</html>
