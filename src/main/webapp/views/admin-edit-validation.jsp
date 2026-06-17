<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理編集画面</title>
</head>
<body>
	<!-- user-validation -->
	<h2>編集する内容はこちらでよろしいですか？</h2>
	会員ID:<c:out value="${upUser.id}"></c:out><br>
	パスワード:<c:out value="${upUser.pass}"></c:out><br>
	名前(姓):<c:out value="${upUser.lastName}"></c:out><br>
	名前(名):<c:out value="${upUser.firstName}"></c:out><br>
	住所:<c:out value="${upUser.address}"></c:out><br>
	メールアドレス:<c:out value="${upUser.mailAddress}"></c:out><br>
	
	<form action="Edit.action" method="post">
		<button type="submit" type="submit" name="model" value="admin">登録</button>
	</form>
	
	 <button type="button" onclick="location.href='admin-edit.jsp'">
	  戻る
	 </button>
	
</body>
</html>