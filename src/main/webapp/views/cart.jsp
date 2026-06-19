<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート画面</title>
</head>
<body>
	<jsp:include page="/tool/header.jsp" /><hr>

	<c:choose>
		<c:when test="${cart.size() > 0}">
			<p>${cart.size()}個の商品があります</p>
			<hr>
			<c:forEach var="item" items="${cart}">
				<img alt="商品画像"
					src="${pageContext.request.contextPath}/image?name=${item.product.fileName}"
					width="200">

				<c:out value="${item.product.name}"></c:out>
				￥<c:out value="${item.product.price}"></c:out>
				<c:out value="${item.product.description}"></c:out>

				<a href="CartCount.action?id=${item.product.productId}&type=minus">ー</a>
				<c:out value="${item.count}"></c:out>
				<a href="CartCount.action?id=${item.product.productId}&type=plus">＋</a>
		
				￥<c:out value="${item.subTotal}"></c:out>円

				<a href="CartRemove.action?id=${item.product.productId}">削除</a>
			</c:forEach>

			<br>
			<br>
		消費税<c:out value="${tax}"></c:out>円
		合計<c:out value="${totalTax}"></c:out>円
		
		<p>送料は購入手続き時に計算されます</p>

			<form action="purchase-in.jsp" method="post">
				<input type="hidden" name="fromCart" value="true">
				<button>購入手続き</button>
			</form>
			<a href="HomeProduct.action">買い物を続ける</a>
		</c:when>

		<%-- カートの商品がない場合 --%>
		<c:otherwise>
			<p>カートに商品がありません</p>
			<a href="HomeProduct.action">ホーム画面へ戻る</a>
		</c:otherwise>

	</c:choose>



</body>
</html>