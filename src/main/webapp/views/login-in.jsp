<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="login-error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	
	<h2>ログイン画面</h2>
	
	<form action="loginaction" method="post">
		<p>会員ID：<input type="text" name="id" required></p>
		<p>パスワード：<input type="password" name="pass" required></p>
		<input type="submit" value="ログイン"><br>
		<input type="button" value="新規登録">
	</form>
</body>
</html>