<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者情報登録ホーム画面</title>
</head>
<body>
	<jsp:include page="/tool/header.jsp"/>

	<h3>
		<c:out value="ようこそ${user.getLastName()}さん!"></c:out>
	</h3>

	<button type="button" onclick="location.href = 'admin-edit.jsp'">修正</button>
	<button type="button" onclick="location.href = 'admin-delete.jsp'">削除</button>
	<button type="button" onclick="location.href = 'Product.action'">商品管理</button>
	<button type="button" id="logout">ログアウト</button>

	<%@ include file="../tool/dialog.jsp"%>

	<script src="../js/logoutJs.js"></script>
</body>
</html>