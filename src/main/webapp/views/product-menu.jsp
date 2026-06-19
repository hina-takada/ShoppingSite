<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
</head>
<body>

	<h1>商品管理</h1>
	<c:forEach var="product" items="${products}">
		
		<img alt="商品画像" src="${pageContext.request.contextPath}/image?name=${product.fileName}" width="200">
		<c:out value="${product.productId}"></c:out>
		<c:out value="${product.name}"></c:out>
		<c:out value="${product.categoryName}"></c:out>
		<c:out value="${product.price}"></c:out>
		<c:out value="${product.count}"></c:out>
		<c:out value="${product.description}"></c:out>

		<form action="ProductNextEdit.action" method="post">
			<input type="hidden" name="productId" value="${product.productId}">
			<input type="hidden" name="categoryName"
				value="${product.categoryId}">
			<button type="submit" name="model" value="edit">編集</button>
		</form>

		<form action="ProductNextEdit.action" method="post">
			<input type="hidden" name="productId" value="${product.productId}">
			<button type="submit" name="model" value="delete">削除</button>
		</form>
		<br>
	</c:forEach>


	<br>
	<br>
	<button type="button" id="logout"
		onclick="location.href = 'product-add.jsp'">登録</button>

	<a href="admin-menu.jsp">戻る</a>

</body>
</html>