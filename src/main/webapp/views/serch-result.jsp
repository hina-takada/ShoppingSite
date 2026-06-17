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

	<main>
		<h1>検索結果</h1>
		<!-- 検索してなかったら表示する -->
		<c:if test="${products == null }">
			<c:out value="">検索された商品はありません</c:out>
		</c:if>

		<c:forEach var="product" items="${products}">

			<img alt="それぞれの画像" src="/ShoppingSite/img/${product.productId}.jpg"
				width="200">

			<c:out value="${product.name}"></c:out>
			<c:out value="${product.categoryName}"></c:out>
			<c:out value="${product.price}"></c:out>
			<c:out value="${product.count}"></c:out>
			<c:out value="${product.description}"></c:out>
			<br>
		</c:forEach>
	</main>


</body>
</html>