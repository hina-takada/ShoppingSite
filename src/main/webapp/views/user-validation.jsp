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
	<h2>この内容でよろしいですか?</h2>
	
	会員ID:<c:out value="${insertUser.getId()}"></c:out><br>
	パスワード：<c:out value="${insertUser.getPass()}"></c:out><br>
	名前(姓)：<c:out value="${insertUser.getLastName()}"></c:out><br>
	名前(名)：<c:out value="${insertUser.getFirstName()}"></c:out><br>
	住所：<c:out value="${insertUser.getAddress()}"></c:out><br>
	メールアドレス：<c:out value="${insertUser.getMailAddress()}"></c:out><br>
	
	<form action="Add.action" method="post">
		<button type="submit">登録</button>
	</form>
	
	 <button type="button" onclick="location.href='user-add.jsp'">
	  戻る
	 </button>
	
</body>
</html>