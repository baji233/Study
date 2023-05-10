<%@ page language="java" import="java.util.List,entity.Shop" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List list=(List)request.getAttribute("shopList");
		for(int i=0;i<list.size();i++){
			Shop s=(Shop)list.get(i);
	%>
	<span>
		
		商品名称：<%=s.getShopName()%>
		商品价格：<%=s.getPrice()%>
		商品简介：<%=s.getContent()%>
		</br>
	</span>
	<%
		}
	%>

</body>
</html>
