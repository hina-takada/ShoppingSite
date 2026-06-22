<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入確定画面</title>
</head>
<body>
	
	<h1>購入確定</h1>
	
	<main>
		<c:forEach var="item" items="${purchases}">
			<img alt="商品画像"
				src="${pageContext.request.contextPath}/image?name=${item.product.fileName}"
				width="200">

			<c:out value="${item.product.name}"></c:out>
			<c:out value="${item.product.description}"></c:out>
			<c:out value="${item.product.count}"></c:out>
		￥<c:out value="${item.subTotal}"></c:out>
		
	</c:forEach>

		<hr>
			
			小計・<c:out value="${purchases.size()}"/>アイテム
			消費税込み合計<c:out value="${purchases[0].totalTax}"></c:out>
			
			<br>
			
			送料<c:out value="${purchases[0].shippingFee}"></c:out>
			合計<c:out value="${purchases[0].grandTotal}"></c:out>
			
			
			<a href="HomeProduct.action">買い物を続ける</a>
	</main>
	
</body>
</html>