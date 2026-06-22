<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細画面</title>
</head>
<body>
	<jsp:include page="/tool/header.jsp" />

	<img alt="商品画像"
		src="${pageContext.request.contextPath}/image?name=${product.fileName}"
		width="200">

	<c:out value="${product.name}"></c:out>
	<c:out value="${product.categoryName}"></c:out>
	<c:out value="${product.price}"></c:out>円
	<c:out value="${product.description}"></c:out>
	
	<form action="CartAdd.action" method="get">
	<select name="count">
		<c:forEach var="i" begin="1" end="10">
			<option value="${i}">${i}</option>
		</c:forEach>
	</select>
	
	<input type="hidden" name="id" value="${product.productId}">
	<button type="submit">カートに追加</button>
	</form>
	<br>

</body>
</html>