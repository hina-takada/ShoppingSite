<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="商品登録完了"></c:set>
<c:set var="cssFile" value="/css/add-success.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<%--  --%>
<main class="main">

	<div class="header">
		<div class="logo">
			<img alt="ロゴ" src="../img/logo.png">

			<h1 class="title">商品登録が完了しました！</h1>
		</div>

		<section class="card">

			<div class="links-area">
				<a href="Product.action">商品管理画面に戻る</a>
			</div>

		</section>
</main>

<%-- Product.action --%>
</body>
</html>