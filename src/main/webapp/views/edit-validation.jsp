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
	<h2>登録する内容はこちらでよろしいですか？</h2>
	
	名前(姓)：<c:out value="${user.lastName}"></c:out><br>
	名前(名)：<c:out value="${user.firstName}"></c:out><br>
	住所：<c:out value="${user.address}"></c:out><br>
	メールアドレス：<c:out value="${user.mailAddress}"></c:out><br>
	
	<form action="Update.action" method="post">
		<button type="submit">登録</button>
	</form>
	
	 <button type="button" onclick="location.href='user-edit.jsp'">
	  戻る
	 </button>
	
</body>
</html>