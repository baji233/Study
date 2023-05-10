<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2022/10/13
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%!
    //声明脚本
    int num = 10;
%>
<%
    for (int i = 0; i < 10; i++) {
        num += i;
        //向页面输出内容
        out.println(num + "<br/>");
    }
    System.out.println("计算完成！");
%>
<body>
    <!-- 这是HTML注释，客户端可见 -->
    <h3>Hello Jsp!</h3>
    <%-- 这是JSP注释，客户端不可见 --%>
    <h4><%=num %></h4>
    <%@ include file="index.jsp"%>
</body>
</html>
