<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報編集</title>
</head>
<body>
	<h1>会員情報編集画面</h1>
	
	<form action="EditValidation.action" method="post">
		
		名前(姓):<input type="text" name="lastName" value="${user.getLastName()}"><br>
		名前(名):<input type="text" name="firstName" value="${user.getFirstName()}"><br>
		住所:<input type="text" name="address" value="${user.getAddress()}"><br>
		メールアドレス:<input type="text" name="mailAddress" value="${user.getMailAddress()}"><br>
		<input type="submit" value="確認">
	</form>
	
	<a href="user-menu.jsp">会員メニュー画面へ戻る</a>
	
</body>
</html>