<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="categoryId"
	value="${empty inProduct ? product.categoryId:inProduct.categoryId}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録ページ</title>
<link rel="stylesheet" href="../css/product-add.css">
</head>
<body>
	<h2>商品登録</h2>

	<form action="ProductAdd.action" method="post"
		enctype="multipart/form-data" autocomplete="off">
		<div class="field">
			商品名：<input type="text" name="name" placeholder="商品名" data-validate="text"> 
			    <span class="error error-length is-hidden"></span> 
				<span class="error error-regex is-hidden"></span>
		</div>

		<div class="checkbox"><%-- ${categoryId == 3 ? 'checked' : ''} --%>
			<label><input type="radio" name="categoryId" value="1" data-validate="radio">イヌ科</label>
			<label><input type="radio" name="categoryId" value="2" data-validate="radio">ネコ科</label>
			<label><input type="radio" name="categoryId" value="3" data-validate="radio" >クマ科</label>
			<span class="error error-chack is-hidden"></span>
		</div>

		<div class="field">
			価格:<input type="number" name="price" placeholder="10000" min="0" data-validate="number"> <span
				class="error error-num is-hidden"></span>
		</div>
		<div class="field">
			個数：<input type="number" name="count" placeholder="1" min="0"max="9999" data-validate="number"> 
			<span class="error error-num is-hidden"></span>
		</div>
		<div class="field">
			商品説明
			<textarea name="description" rows="10" cols="70" data-validate="text"></textarea>
			<span class="error error-length is-hidden"></span>
		</div>
		<div class="field">
			商品画像 <input type="file" name="img" data-validate="file"> <span
				class="error error-file is-hidden"></span>
		</div>
		<input id="vali-btu" type="submit" value="登録" disabled>
	</form>

	<a href="product-menu.jsp">商品管理画面へ戻る</a>

	<%@ include file="../tool/dialog.jsp"%>
	<script src="../js/product-add.js"></script>
</body>
</html>