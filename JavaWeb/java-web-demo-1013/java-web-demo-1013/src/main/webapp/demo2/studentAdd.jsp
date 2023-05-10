<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2022/10/13
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="com.jiuyun.bean.Student" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <%--%>
<%--        String stuId = request.getParameter("stuId");--%>
<%--        String stuName = request.getParameter("stuName");--%>
<%--        String sex = request.getParameter("sex");--%>
<%--        String age = request.getParameter("age");--%>

<%--        Student student = new Student(stuId, stuName, sex, age);--%>
<%--        pageContext.setAttribute("student", student);--%>
<%--    %>--%>

    <jsp:useBean id="student" class="com.jiuyun.bean.Student" scope="page"/>
    <jsp:setProperty name="student" property="*"/>

<%--    <jsp:setProperty name="student" property="stuId" value="1"/>--%>
<%--    <jsp:setProperty name="student" property="stuName" value="jack"/>--%>
<%--    <jsp:getProperty name="student" property="sex"/>--%>
<%--    <%=((Student)pageContext.getAttribute("student")).getSex()%>--%>
<%--    <h1>学员信息：<%=pageContext.getAttribute("student")%></h1>--%>
    <h1>学员信息：</h1>
    <h3>表达式获取</h3>
    <h4>学号：<%=((Student)pageContext.getAttribute("student")).getStuId()%></h4>
    <h4>姓名：<%=((Student)pageContext.getAttribute("student")).getStuName()%></h4>
    <h4>性别：<%=((Student)pageContext.getAttribute("student")).getSex()%></h4>
    <h4>年龄：<%=((Student)pageContext.getAttribute("student")).getAge()%></h4>
    <h3>标准动作获取</h3>
    <h4>学号：<jsp:getProperty name="student" property="stuId"/></h4>
    <h4>姓名：<jsp:getProperty name="student" property="stuName"/></h4>
    <h4>性别：<jsp:getProperty name="student" property="sex"/></h4>
    <h4>年龄：<jsp:getProperty name="student" property="age"/></h4>
    <h3>EL表达式获取</h3>
    <h4>学号：${student.stuId}</h4>
    <h4>姓名：${student.stuName}</h4>
    <h4>性别：${student.sex}</h4>
    <h4>年龄：${student.age}</h4>
</body>
</html>
