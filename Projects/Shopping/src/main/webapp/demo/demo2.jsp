<%--
  Created by IntelliJ IDEA.
  User: 29490
  Date: 2022/10/26
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%!

%>

<%
    // http://localhost:8080/Shopping/demo/demo2.jsp

    Integer count = (Integer) pageContext.getAttribute("count2");
    if(pageContext.getAttribute("count2") == null){
        pageContext.setAttribute("count2",1);
    }else {
        pageContext.setAttribute("count2",++count);
    }

    count = (Integer) request.getAttribute("count1");
    if(count == null){
        request.setAttribute("count1",1);
    }else {
        request.setAttribute("count1",++count);
    }

    count = (Integer) session.getAttribute("count3");
    if(session.getAttribute("count3") == null){
        session.setAttribute("count3",1);
    }else {
        session.setAttribute("count3",++count);
    }

    count = (Integer) application.getAttribute("count4");
    if(application.getAttribute("count4") == null){
        application.setAttribute("count4",1);
    }else {
        application.setAttribute("count4",++count);
    }
%>
<body>
<h1>
    pageContext=<%=pageContext.getAttribute("count2")%><br>
    request=<%=request.getAttribute("count1")%><br>
    session=<%=session.getAttribute("count3")%><br>
    application=<%=application.getAttribute("count4")%><br>
</h1>
</body>
</html>
