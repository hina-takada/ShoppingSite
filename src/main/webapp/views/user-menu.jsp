<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報登録ホーム画面</title>

</head>
<body>
	<h3>ようこそ${user.getLastName()}さん!</h3>

	<button>修正</button>
	<button>削除</button>
	<button type="button" id="logout">ログアウト</button>
	
	<!-- ダイアログ用 -->
	<dialog id="myDialog">
		<p>本当によろしいですか？</p>
		<button type="button" id="okBtu">はい</button>
		<button type="button" id="noBtu">いいえ</button>
	</dialog>
	
	<script src="../js/logoutJs.js"></script>
</body>
</html>