<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/css/header.css'/>">
<title>会員情報登録ホーム画面</title>

</head>
<body>

	<jsp:include page="/tool/header.jsp" />

	<main>
		<h3>
			<c:out value="ようこそ${user.getLastName()}さん!"></c:out>
		</h3>

		<button type="button" onclick="location.href = 'user-edit.jsp'">修正</button>
		<button type="button" onclick="location.href = 'user-delete.jsp'">削除</button>
		<button type="button" id="logout">ログアウト</button>

		<hr>

		<div>
			<h4>購入履歴</h4>
			<c:if test="${not empty historyMap}">
				<c:out value="時間：${historys[0].registdate}"></c:out>

				<c:forEach var="historys" items="${historyMap}">

					<h3>${historys.key}</h3>

					<c:forEach var="history" items="${historys.value}">
						<img alt="商品画像"
							src="${pageContext.request.contextPath}/image?name=${history.product.fileName}"
							width="200">
						<c:out value="商品名：${history.product.name}"></c:out>
						<c:out value="価格：${history.product.price}"></c:out>
						<c:out value="個数：${history.product.count}"></c:out>
						<c:out value="小計：${history.subTotal}"></c:out>
						<c:out value="名前_姓：${history.user.lastName}"></c:out>
						<c:out value="名前_名：${history.user.firstName}"></c:out>
						<c:out value="住所：${history.user.address}"></c:out>
					</c:forEach>


					<c:set var="hist" value="${historys.value[0]}" />

					<c:out value="消費税：${hist.tax}"></c:out>
					<c:out value="消費税込：${hist.totalTax}"></c:out>
					<c:out value="送料：${hist.shippingFee}"></c:out>
					<c:out value="総合計：${hist.grandTotal}"></c:out>

				</c:forEach>
			</c:if>
		</div>

	</main>
	<%@ include file="../tool/dialog.jsp"%>

	<script src="../js/logoutJs.js"></script>
</body>
</html>