<%--
  Created by IntelliJ IDEA.
  User: 29490
  Date: 2022/10/26
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<%!
//声明属性或者方法
    public int method1(){
        int i = 9;
        return i;
    }
%>
<body>
<!--表达式-->
<%=method1()%>

<!--脚本小程序-->
<%
for(int i=0;i<=5;i++){
//        System.out.println(i);
}
%>

<h1>
    <form action="/demo1/login">
        名称：<input type="text" name="name">
        密码：<input type="password" name="password">
        <input type="submit" value="登录">
    </form>
</h1>

</body>
</html>
