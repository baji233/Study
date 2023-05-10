<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style='color:red'>我是登录页面</h1>
	<form action="LoginServlet" method="post">
		用户名：<input type="text" name="username"/></br>
		密码：<input type="text" name="password"/></br>
		<span style="color:red;">${msg}</span>
		<input type="submit" value="登录"/>
	</form>
	
</body>
</html>