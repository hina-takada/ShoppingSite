<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>未ログイン画面</title>
</head>
<body>
	<jsp:include page="/tool/header.jsp" />
	
	<h1>ログイン・新規登録</h1>
	
	<p>すでに会員の方</p>
	<a href="login-in.jsp">ログイン</a>
	

	<p>はじめての方</p>
	<a href="user-add.jsp">新規アカウント登録</a>
	

</body>
</html>