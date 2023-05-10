<%@ page language="java" import="entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<%
		Shop s=(Shop)request.getAttribute("shop");
	%>
	<%=s.getShopName() %>
	
</body>
</html>