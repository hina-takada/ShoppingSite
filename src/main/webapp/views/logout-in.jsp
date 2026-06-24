<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="ログアウト画面"></c:set>
<c:set var="cssFile" value="/css/logout.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<%--  --%>
<main class="main">


	<div class="header">
		<div class="logo">
			<img alt="ロゴ" src="../img/logo.png">
		</div>

		<h2 class="title">ログアウト</h2>
	</div>

	<section class="card">

		<div class="card-left">
			<div class="card-img">
				<img alt="肉球を押し付けるイヌ" src="../img/inu_nikukyu4.jpg">
			</div>

			<p class="left-msg">またきてね</p>

		</div>

		<div class="card-rigth">
			<p class="card-msg">ログアウトしました</p>

			<div class="links">
			
			<div class="link-box">
			<span class="icon"> <i class="fas fa-arrow-right"></i></span>
				<a class="link" href="HomeProduct.action">ホーム画面へ</a> 
			</div>
			
			<div class="link-box">
			<span class="icon"> <i class="fas fa-arrow-right"></i></span>
				<a class="link" href="login-in.jsp">ログイン画面へ</a>
			</div>
			
			</div>
		</div>

	</section>

</main>

</body>
</html>