<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入手続き画面</title>
<link rel="stylesheet" href="<c:url value='/css/purchases.css'/>">
</head>
<body>

	<main>
		<c:forEach var="item" items="${cart}">
			<img alt="商品画像"
				src="${pageContext.request.contextPath}/image?name=${item.product.fileName}"
				width="200">

			<c:out value="${item.product.name}"></c:out>
			<c:out value="${item.product.description}"></c:out>
			<c:out value="${item.count}"></c:out>
		￥<c:out value="${item.subTotal}"></c:out>
		
	</c:forEach>

		<hr>
			
			小計・<c:out value="${cart.size()}"/>アイテム
			￥<c:out value="${totalTax}"></c:out>
			
			<br>
			
			送料<c:out value="${SHIPPING_FEE}"></c:out>
			合計<c:out value="${grandTotal}"></c:out>


		<div class="form">
			<form action="Purchases.action" method="post">
				お名前_姓<input id="buy-lastname" type="text" name="last-name" value="${user.getLastName()}"> 
				<span id="error-msg-lastname" 
				class="errorMsg"></span> 
				
				お名前_名<input id="buy-firstname" type="text" name="first-name" value="${user.getFirstName()}"> 
				<span id="error-msg-firstname" class="errorMsg"></span> 
				
				ご住所<input id="buy-address" type="text" name="address" value="${user.getAddress()}"> 
				<span id="error-msg-address" class="errorMsg"></span> 
				<input type="submit" value="購入を確定">
			</form>
		</div>
		<a href="cart.jsp">カートに戻る</a>
	</main>

	<%@ include file="../tool/dialog.jsp"%>
	<script src="../js/purchases.js"></script>
</body>
</html>