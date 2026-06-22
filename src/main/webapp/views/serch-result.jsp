<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面</title>
</head>
<body>
	
	<jsp:include page="/tool/header.jsp" />
	
		<h1>検索結果</h1>
		
		<!-- 検索してなかったら表示する -->
		<c:if test="${empty products }">
			<p>検索された商品はありません</p>
		</c:if>
		
		<c:if test="${not empty products }">
			<main>
		<c:forEach var="product" items="${products}">
		<a href="ProductDetail.action?id=${product.productId}">
		
		<img alt="商品画像" src="${pageContext.request.contextPath}/image?name=${product.fileName}" width="200">
		<c:out value="${product.name}"></c:out>
		<c:out value="${product.price}"></c:out>円
		<c:out value="${product.description}"></c:out>
		
		</a>
	<br>
	</c:forEach>
	
	</main>
	<footer> </footer>
	
	</c:if>

<script src="../js/home.js"></script>
</body>
</html>