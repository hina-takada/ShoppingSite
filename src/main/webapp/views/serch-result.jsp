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
		<c:if test="${empty products }">
			<p>検索された商品はありません</p>
		</c:if>
		
		<c:if test="${not empty products }">
			<jsp:include page="/views/home.jsp" />
		</c:if>
	</main>


</body>
</html>