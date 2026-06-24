<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="ログアウト画面"></c:set>
<c:set var="cssFile" value="/css/logout.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<%--  --%>
<main class="logout-main">


	<div class="logout-header">
		<div class="logout-logo">
			<img alt="ロゴ" src="../img/logo.png">
		</div>

		<h2 class="logout-title">ログアウト</h2>
	</div>

	<section class="logout-card">

		<div class="card-left">
			<div class="logout-img">
				<img alt="肉球を押し付けるイヌ" src="../img/inu_nikukyu4.jpg">
			</div>

			<p class="left-msg">またきてね</p>

		</div>

		<div class="card-rigth">
			<p class="logout-msg">ログアウトしました</p>

			<div class="logout-links">
			
			<div class="logout-link-box">
			<span class="icon"> <i class="fas fa-arrow-right"></i></span>
				<a class="logout-link" href="HomeProduct.action">ホーム画面へ</a> 
			</div>
			
			<div class="logout-link-box">
			<span class="icon"> <i class="fas fa-arrow-right"></i></span>
				<a class="logout-link" href="login-in.jsp">ログイン画面へ</a>
			</div>
			
			</div>
		</div>

	</section>

</main>

</body>
</html>