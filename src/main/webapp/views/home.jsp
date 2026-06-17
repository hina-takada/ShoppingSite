<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<c:url value='/tool/header.css'/>">
<link rel="stylesheet" href="<c:url value='/css/home.css'/>">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<title>NIKUKYKU ONRLINE STORE</title>
</head>
<body>
<%-- header用のinc --%>
	<jsp:include page="/tool/header.jsp"/>

	<main>
		<c:forEach var="product" items="${products}">
		<img alt="商品画像" src="upload/${product.fileName}.jpg" width="200">
		
		<c:out value="${product.productId}"></c:out>
		<c:out value="${product.name}"></c:out>
		<c:out value="${product.categoryName}"></c:out>
		<c:out value="${product.price}"></c:out>
		<c:out value="${product.count}"></c:out>
		<c:out value="${product.description}"></c:out>
	<br>
	</c:forEach>
	
	</main>


	<footer> </footer>

	<script src="../js/home.js"></script>
</body>
</html>