<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="登録エラー画面"></c:set>
<c:set var="cssFile" value="/css/error.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<div class="error-main">

	<h1 class="error-title">登録エラー</h1>

	<main class="error-card">

		<img src="../img/error_img.jpg">

		<div class="error-text">

			<p>
			入力されたものが合っていないか、<br>
			使われているIDを入力しています
			</p>
			

			<div class="back-link">
				<span class="icon"> <i class="fas fa-arrow-right"></i></span>
				<a href="user-add.jsp">会員登録画面へ戻る</a>
			</div>

		</div>

	</main>
</div>
</body>
</html>