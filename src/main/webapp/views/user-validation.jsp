<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録用確認画面</title>
</head>
<body>
	<!-- user-validation -->
	
	会員ID:<c:out value="${id}"></c:out>
	パスワード：<c:out value="${pass}"></c:out>
	名前(姓)：<c:out value="${lastName}"></c:out>
	名前(名)：<c:out value="${firstName}"></c:out>
	住所：<c:out value="${address}"></c:out>
	メールアドレス：<c:out value="${meilAddress}"></c:out>
	
	<a href=".jsp"><button type="button">登録する</button></a>
	<a href="userAdd.jsp"><button type="button">戻る</button></a>
	
</body>
</html>