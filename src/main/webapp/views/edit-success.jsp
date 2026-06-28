<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="会員情報編集完了 画面"></c:set>
<c:set var="cssFile" value="/css/add-success.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<main class="main">
	<div class="header">
		<div class="logo">
			<img alt="ロゴ" src="../img/logo.png">

			<h1 class="title">編集登録完了</h1>
		</div>

		<section class="card">
			<p>
				編集が完了しました <i class="fas fa-paw pow1"></i>
			</p>

			<div class="links-area">
				<a href="user-menu.jsp">会員メニュー画面へ戻る</a>
			</div>
	</div>
	</section>
</main>
</body>
</html>