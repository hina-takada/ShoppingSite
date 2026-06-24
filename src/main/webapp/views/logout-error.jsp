<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="ログアウトエラー画面"></c:set>
<c:set var="cssFile" value="/css/error.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<%--  --%>

<div class="error-main">

	<h2 class="error-title">ログアウトエラー</h2>
	<main class="error-card">

		<img src="../img/error_img.jpg">

		<div class="error-text">


			<p>すでにログアウトしています</p>

			<div class="back-link">
				<span class="icon"> <i class="fas fa-arrow-right"></i>
				</span> <a href="login-in.jsp">ログイン画面へ戻る</a>
			</div>

		</div>

	</main>
</div>

</body>
</html>