<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報編集</title>
<link rel="stylesheet" href="../css/user-edit.css">
</head>
<body>
	<h1>会員情報編集画面</h1>

	<form action="EditValidation.action" method="post">
		<div class="filed">
			名前(姓):<input type="text" name="lastName"
				value="${empty upUser ? user.lastName : upUser.lastName}">
			<span class="error is-hidden"></span>
		</div>
		
		
		<div class="filed">
			名前(名):<input type="text" name="firstName"
				value="${empty upUser ? user.firstName : upUser.firstName}">
			<span class="error is-hidden"></span>
		</div>
		
		
		<div class="filed">
			住所:<input type="text" name="address"
				 value="${empty upUser ? user.address : upUser.address}">
			<span class="error is-hidden"></span>
		</div>
		
		<div class="filed">
			メールアドレス:<input type="text" name="mailAddress"
				value="${empty upUser ? user.mailAddress : upUser.mailAddress}">
			<span class="error is-hidden"></span>
		</div>
		
		<input id="vail-btu" type="submit" value="確認" >
	</form>

	<a href="user-menu.jsp">会員メニュー画面へ戻る</a>

	<script src="../js/user-edit.js"></script>
</body>
</html>