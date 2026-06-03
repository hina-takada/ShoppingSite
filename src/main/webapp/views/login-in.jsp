<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<title>ログイン画面</title>
<link rel="stylesheet" href="<c:url value='/css/login-in.css' />">
</head>
<body>

	<main class="login-main">
		<div class="login-card">

			<h2 class="login-title">ログイン</h2>

			<form class="login-form" action="Login.action" method="post">


				<div class="form-group">
					<label class="form-label">会員ID</label>
					<!-- 半角英数文字 -->
					<input id="form-id" class="login-text" type="text" name="id" placeholder="ID入力" >
					<i class="fa-solid fa-eye-slash"></i>
					<div id="errorMsgId" class="errorMsg"></div>
				</div>

				<div class="form-group">
					<!-- 半角英数文字 -->
					<label class="form-label">パスワード</label> 
					<input id="form-pass" class="login-text" type="password" name="pass" placeholder="パスワード入力">
					<i class="fa-solid fa-eye-slash"></i>
					<div id="errorMsgPass" class="errorMsg"></div>
				</div>

				<div class="form-action">
					<input id="login-btu" type="submit" value="ログイン" disabled>
				</div>


			</form>
		</div>
			
		<div class="link-area">
			<a href=<c:url value='/views/user-add.jsp'/>>新規会員登録</a>
		</div>
		
	</main>

	<script src="../js/login-in.js"></script>
</body>
</html>