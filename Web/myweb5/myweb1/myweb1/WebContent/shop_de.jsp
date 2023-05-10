<%@ page language="java" import="entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String head="head.jsp";
	%>
	
	<jsp:include page="<%=head %>"></jsp:include>
	
	<%
		Shop s=(Shop)request.getAttribute("shop");
	%>
	<%=s.getShopName() %>
	<%=s.getPrice() %>
	<%=s.getContent() %>
	<a href="CartServlet?me=add&shopId=<%=s.getShopId() %>"><input type="button" value="购买"/></a>
	
</body>
</html>