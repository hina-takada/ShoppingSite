<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録ページ</title>
<link rel="stylesheet" href="../css/user-add.css">
</head>
<body>
	<h2>商品登録</h2>

	<form action="AddValidation.action" method="post" autocomplete="off">
		<div class="field">
			商品名：<input type="text" name="name" placeholder="商品名"
				value="" > 
			<span class="error error-length is-hidden"></span>
		</div>
		<div class="field">
			価格:<input type="number" name="price" placeholder="10000"
				value="" min="0" step="100">
			<span class="error error-length is-hidden"></span>
		</div>
		<div class="field">
			個数：<input type="number" name="count" placeholder="1"
				value="">
			<span class="error error-length is-hidden"></span>
		</div>
		<input id="vali-btu" type="submit" value="確認" disabled>
	</form>

	<a href="product-menu.jsp" >商品管理画面へ戻る</a>

	<script src="../js/user-add.js"></script>
</body>
</html>