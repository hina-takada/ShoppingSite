<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/css/header.css'/>">
<title>会員情報登録ホーム画面</title>

</head>
<body>

	<jsp:include page="/tool/header.jsp" />

	<main>
		<h3>
			<c:out value="ようこそ${user.getLastName()}さん!"></c:out>
		</h3>

		<button type="button" onclick="location.href = 'user-edit.jsp'">修正</button>
		<button type="button" onclick="location.href = 'user-delete.jsp'">削除</button>
		<button type="button" id="logout">ログアウト</button>

	</main>
	<%@ include file="../tool/dialog.jsp"%>

	<script src="../js/logoutJs.js"></script>
</body>
</html>