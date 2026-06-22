<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- <%@ taglib prefix="fn" uri="jakarta.tags.functions"%> --%>
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
	<jsp:include page="/tool/header.jsp" />

	<main>
		<div class="sort">
			<button id="sortBtu">並べ替え ▽</button>

			<div id="sortMenu" class="sort-menu">
				<a href="javascript:void(0)" onclick="sortSubmit('name')">名前順</a> <a
					href="javascript:void(0)" onclick="sortSubmit('low')">価格が安い順</a> <a
					href="javascript:void(0)" onclick="sortSubmit('high')">価格が高い順</a>
			</div>
		</div>

		<div id="category">
			<form id="filterForm" action="ProductSort.action" method="get">

				<input type="hidden" name="sort" value="${param.sort}"> <label><input
					type="checkbox" name="category" value="1" onchange="autoSubmit()"
					<c:forEach var="c" items="${paramValues.category}">
					<c:if test="${c == '1'}">checked</c:if>
				</c:forEach>>イヌ科</label>

				<label><input type="checkbox" name="category" value="2"
					onchange="autoSubmit()"
					<c:forEach var="c" items="${paramValues.category}">
					<c:if test="${c == '2'}">checked</c:if>
				</c:forEach>>ネコ科</label>

				<label><input type="checkbox" name="category" value="3"
					onchange="autoSubmit()"
					<c:forEach var="c" items="${paramValues.category}">
					<c:if test="${c == '3'}">checked</c:if>
				</c:forEach>>クマ科</label>

			</form>
		</div>


		<div class="product">
			<c:forEach var="product" items="${products}">
				<a href="ProductDetail.action?id=${product.productId}"> <img
					alt="商品画像"
					src="${pageContext.request.contextPath}/image?name=${product.fileName}"
					width="200"> <c:out value="${product.name}"></c:out> <c:out
						value="${product.price}"></c:out>円 <c:out
						value="${product.description}"></c:out>
				</a>
			</c:forEach>
		</div>

	</main>


	<footer> </footer>

	<script src="../js/product-sort.js"></script>
</body>
</html>