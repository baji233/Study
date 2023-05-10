<%--
  Created by IntelliJ IDEA.
  User: 29490
  Date: 2022/10/13
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>
    <input type="submit" name="注销" >
</h1>
<%
    session.removeAttribute("userName");
Integer count= (Integer) application.getAttribute("count");
if(count!=null && count==0) {
    application.setAttribute("count", --count);
}else{

}
%>
</body>
</html>
