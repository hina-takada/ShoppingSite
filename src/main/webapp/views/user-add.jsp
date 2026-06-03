<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録ページ</title>
</head>
<body>
	<h2>会員情報登録</h2>

	<form action="Validation.action" method="post">
		<!-- 半角英数文字 -->
		会員ID：<input type="text" name="id" minlength="4" maxlength="10"
			placeholder="ID入力" value="${user.id}" required><br>
		<!-- 半角英数文字 -->
		パスワード：<input type="text" name="pass" minlength="8" maxlength="32"
			placeholder="パスワード入力" value="${user.pass}" required> <br>
		名前：（姓）<input type="text" name="lastName" maxlength="32" placeholder="例:山田" value="${user.lastName}" required><br> 
		名前：（名）<input type="text" name="firstName" maxlength="32" placeholder="例:太郎" value="${user.firstName}" required><br>
		住所：<input type="text" name="address" maxlength="128" placeholder="○○県○○市○○XXXX-XX" value="${user.address}" required> <br>
	   	メールアドレス：<input type="text" name="mailAddress" maxlength="128" placeholder="○○○○@mail.com" value="${user.mailAddress}" required><br>
		<!-- パスワード確認用：<input type="text" name=""> -->
		<input type="submit" value="確認">
	</form>

	<a href="login-in.jsp">ログイン画面へ戻る</a>

</body>
</html>