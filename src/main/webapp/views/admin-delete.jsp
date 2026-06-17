<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除画面</title>
</head>
<body>
	
	<h1>会員を削除してよろしいですか？</h1>
	 <p>${user.lastName}さん</p>
	
	<button type="button" name="model" value="admin" onclick="location.href = 'Delete.action'">はい</button>
	<button type="button" onclick="location.href = 'admin-menu.jsp'">いいえ</button>
	
</body>
</html>