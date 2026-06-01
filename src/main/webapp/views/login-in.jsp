<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page errorPage="login-error.jsp"%>
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

				<div class="form-group" >
					<label class="form-label">会員ID</label>
					<input id="form-id" class="login-text" type="text" name="id" minlength = "4" maxlength="10" placeholder="ID入力" required>
					<!-- <div id="errorMsgId" class="errorMsg">4～10文字で入力してください</div> -->
				</div>

				<div class="form-group">
					<label class="form-label">パスワード</label>
					<input id="form-pass" class="login-text" type="password" name="pass" minlength = "5" maxlength="32" placeholder="パスワード入力" required>
					<!-- <div id="errorMsgPass" class="errorMsg">5～32文字で入力してください</div> -->
				</div>

				<div class="form-action">
					<input id="login-btu" type="submit" value="ログイン">
				</div>
				
				
			</form>
		</div>
		
		<!-- <div class="link-area">
		<input  type="button" value="新規登録">
		</div> -->
		
	</main>

	<!-- <script src="../js/login-in.js"></script> -->
</body>
</html>