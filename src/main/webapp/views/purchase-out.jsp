<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="購入確定画面"></c:set>
<c:set var="cssFile" value="/css/purchases-out.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>

<h1>購入確定</h1>

<main>
	
	<c:forEach var="item" items="${purchases}">

		<div class="purchase-card">

			<img alt="商品画像"
				src="${pageContext.request.contextPath}/image?name=${item.product.fileName}"
				width="200">

			<div class="purchase-card-info">

				<p>
					<c:out value="${item.product.name}"></c:out>
				</p>

				<p>
					<c:out value="${item.product.description}"></c:out>
				</p>

				<p>
					数量：
					<c:out value="${item.count}"></c:out>
				</p>

				<p class="price">
					￥
					<c:out value="${item.subTotal}"></c:out>
				</p>

			</div>

		</div>

	</c:forEach>

	<hr>

	<div class="purchase-summary">

	<p>
	小計・
	<c:out value="${purchases.size()}"/>アイテム
	</p>

	<p>
	税込み合計
	<c:out value="${purchases[0].totalTax}">
	</c:out>
	</p>

	<p>
	送料
	<c:out value="${purchases[0].shippingFee}">
	</c:out>
	</p>

	<p class="purchase-total">
	合計
	<c:out value="${purchases[0].grandTotal}">
	</c:out>
	</p>

</div>

	<a href="HomeProduct.action">買い物を続ける</a>
</main>

</body>
</html>