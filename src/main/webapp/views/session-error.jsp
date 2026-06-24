<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="セッションエラー画面"></c:set>
<c:set var="cssFile" value="/css/error.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<%--  --%>
<div class="error-main">

	<h1 class="error-title">セッションエラー</h1>

	<main class="error-card">
		<img src="../img/error_img.jpg">

		<div class="back-link">
			<span class="icon"> <i class="fas fa-arrow-right"></i></span> <a
				href="${backPage}">前の画面へ戻る</a>
		</div>
		<c:remove var="backPage" scope="session" />
	</main>
</div>
</body>
</html>