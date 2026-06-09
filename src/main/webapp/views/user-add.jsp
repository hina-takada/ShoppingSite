<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録ページ</title>
<link rel="stylesheet" href="../css/user-add.css">
</head>
<body>
	<h2>会員情報登録</h2>

	<form action="AddValidation.action" method="post" autocomplete="off">
		<div class="field">
			<!-- 半角英数文字 -->
			会員ID：<input type="text" name="id" placeholder="ID入力"
				value="${insertUser.id}" autocomplete="off"> 
			<span class="error error-length is-hidden"></span>
			<span class="error error-id is-hidden"></span>
		</div>
		<!-- 半角英数文字 -->
		<div class="field">
			パスワード：<input type="text" name="pass" placeholder="パスワード入力"
				value="${insertUser.pass}" autocomplete="new-password"> 
			<span class="error error-length is-hidden"></span>
		</div>
		<div class="field">
			名前：（姓）<input type="text" name="lastName" placeholder="例:山田"
				value="${insertUser.lastName}">
			<span class="error error-length is-hidden"></span>
		</div>
		<div class="field">
			名前：（名）<input type="text" name="firstName" placeholder="例:太郎"
				value="${insertUser.firstName}">
			<span class="error error-length is-hidden"></span>
		</div>
		<div class="field">
			住所：<input type="text" name="address" placeholder="○○県○○市○○XXXX-XX"
				value="${insertUser.address}"> 
			<span class="error error-length is-hidden"></span>
		</div>
		<div class="field">
			メールアドレス：<input type="email" name="mailAddress"
				placeholder="○○○○@mail.com" value="${insertUser.mailAddress}">
			<span class="error error-length is-hidden"></span>
		</div>
		<%-- パスワード確認用：<input type="text" name="">  --%>
		<input id="vali-btu" type="submit" value="確認" disabled>
	</form>

	<a href="login-in.jsp" >ログイン画面へ戻る</a>

	<script src="../js/user-add.js"></script>
</body>
</html>