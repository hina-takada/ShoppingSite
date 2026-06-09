<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
</head>
<body>
	
	<h1>商品管理</h1>
	<c:forEach var="product" items="${products}">
		<c:out value="${product.getProductId()}"></c:out>
		<c:out value="${product.getName()}"></c:out>
		<c:out value="${product.getPrice()}"></c:out>
		<c:out value="${product.getCount()}"></c:out>
	</c:forEach>
	
	
	<br><br>
	
	<button type="button" onclick="location.href = 'product-add.jsp'">登録</button>
	<button type="button" onclick="location.href = 'product-edit.jsp'">編集</button>
	<button type="button" onclick="location.href = 'product-delete.jsp'">削除</button>
	
	<a href="admin-menu.jsp">戻る</a>
	
</body>
</html>