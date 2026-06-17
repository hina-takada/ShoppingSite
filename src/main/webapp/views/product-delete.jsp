<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除画面</title>
</head>
<body>

	<h1>商品を削除してよろしいですか？</h1>
	<p>商品名：<c:out value="${upProduct.name}"></c:out></p>
	<p>科目名：<c:out value="${upProduct.categoryName}"></c:out></p>

	<button type="button" onclick="location.href = 'ProductDelete.action'">はい</button>
	<button type="button" onclick="location.href = 'product-menu.jsp'">いいえ</button>

</body>
</html>