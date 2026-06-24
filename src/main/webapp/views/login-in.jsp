<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="ログイン画面"></c:set>
<c:set var="cssFile" value="/css/login-in.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<%--  --%>

<main class="login-main">
	<div class="login-card">

		
		<h2 class="login-title">
		<div class="paw-group left-pow">
		<i class="fas fa-paw pow1"></i>
		<i class="fas fa-paw left-pow2"></i>
		<i class="fas fa-paw pow3"></i>
		</div>
		ログイン
		<div class="paw-group">
		<i class="fas fa-paw pow1"></i>
		<i class="fas fa-paw pow2"></i>
		<i class="fas fa-paw pow3"></i>
		</div>
		</h2>

		<form class="login-form" action="Login.action" method="post"
			autocomplete="off">


			<div class="form-group">
				<label class="form-label">会員ID</label>
				<!-- 半角英数文字 -->
				<div class="pass_box">
					<input id="form-id" class="login-text" type="text" name="id"
						placeholder="ID入力" autocomplete="off">
				</div>
				<div id="errorMsgId" class="errorMsg"></div>
			</div>

			<div class="form-group">
				<!-- 半角英数文字 -->
				<label class="form-label">パスワード</label>
				<div class="pass_box">
					<input id="form-pass" class="login-text" type="password"
						name="pass" placeholder="パスワード入力" autocomplete="off"> 
						<i id="fa-eye" class="fas fa-eye" aria-hidden="true"></i>
				</div>
				<div id="errorMsgPass" class="errorMsg"></div>
			</div>

			<div class="form-action">
				<input id="login-btu" type="submit" value="ログイン" disabled>
			</div>
		</form>

		<div class="link-area">
			アカウントをお持ちでない方
			<a href=<c:url value='/views/user-add.jsp'/>>新規会員登録</a>
		</div>
	</div>

</main>

<script src="../js/login-in.js"></script>
</body>
</html>