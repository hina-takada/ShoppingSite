<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="未ログイン画面"></c:set>
<c:set var="cssFile" value="/css/not-logged.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>

<jsp:include page="/tool/header.jsp" />
<main class="auth">
	
		<h1 class="auth-title">
			<div class="paw-group left-pow">
				<i class="fas fa-paw pow1"></i> <i class="fas fa-paw left-pow2"></i>
				<i class="fas fa-paw pow3"></i>
			</div>
			ログイン・新規登録
			<div class="paw-group">
				<i class="fas fa-paw pow1"></i> <i class="fas fa-paw pow2"></i> <i
					class="fas fa-paw pow3"></i>
			</div>
		</h1>
		
		<div class="auth-container">

		<section class="auth-card card-header-right">

			<div class="auth-card-header">すでに会員の方</div>

			<div class="auth-card-body">
				<h2 class="auth-card-title">ログイン</h2>

				<p class="auth-card-text">
					登録済みのアカウントで、<br>ログインをお願いします。
				</p>

				<a href="login-in.jsp"
					class="auth-card-button auth-card-button--login"> ログイン </a>
			</div>

		</section>



		<!-- 新規登録 -->
		<section class="auth-card card-header-left">

			<div class="auth-card-header">はじめてのお客さま</div>

			<div class="auth-card-body">

				<h2 class="auth-card-title">新規アカウント登録</h2>

				<p class="auth-card-text">
					アカウントを作成して、<br>ログインをお願いします。
				</p>

				<a href="user-add.jsp"
					class="auth-card-button auth-card-button--register"> 新規アカウント登録
				</a>

			</div>

		</section>
	</div>
</main>

</body>
</html>