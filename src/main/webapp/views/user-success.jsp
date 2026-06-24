<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="登録完了 画面"></c:set>
<c:set var="cssFile" value="/css/add-success.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<main class="main">

	<div class="header">
		<div class="logo">
			<img alt="ロゴ" src="../img/logo.png">

			<h1 class="title">会員登録が完了しました！</h1>
		</div>

		<section class="card">
			<p>
				ご登録ありがとうございます
				<i class="fas fa-paw pow1"></i>
			</p>

			<div class="links-area">
				<a href="login-in.jsp">ログイン画面に進む</a>
				<a href="HomeProduct.action">ホーム画面に進む</a>
			</div>

		</section>
</main>

</body>
</html>