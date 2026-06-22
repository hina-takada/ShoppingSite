<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報編集</title>
<link rel="stylesheet" href="../css/product-edit.css">
</head>
<body>
	<h1>商品情報編集画面</h1>

	<form action="ProductEdit.action" method="post" enctype="multipart/form-data">
		<div class="field">
				<input type="hidden" name="productId" value="${upProduct.productId}"> 
			商品名：<input type="text" name="name" value="${upProduct.name}"
				data-validate="text"> 
				<span class="error error-length is-hidden"></span> 
				<span class="error error-regex is-hidden"></span>
		</div>

		<div class="checkbox">
			<label><input type="radio" name="categoryId" value="1"
				data-validate="radio" ${upProduct.categoryId == 1 ? 'checked' : ''}>イヌ科</label>
			<label><input type="radio" name="categoryId" value="2"
				data-validate="radio" ${upProduct.categoryId == 2 ? 'checked' : ''}>ネコ科</label>
			<label><input type="radio" name="categoryId" value="3"
				data-validate="radio" ${upProduct.categoryId == 3 ? 'checked' : ''}>クマ科</label>
			<span class="error error-chack is-hidden"></span>
		</div>

		<div class="field">
			価格:<input type="number" name="price" value="${upProduct.price}" min="0" data-validate="number"> 
			<span class="error error-num is-hidden"></span>
		</div>
		<div class="field">
			在庫数：<input type="number" name="count" value="${upProduct.count}" min="0" max="9999" data-validate="number"> 
				<span class="error error-num is-hidden"></span>
		</div>

		<div class="field">
			<p>商品説明</p>
			<textarea name="description" rows="10" cols="70" data-validate="text"><c:out value="${upProduct.description}"></c:out></textarea>
			<span class="error error-length is-hidden"></span>
		</div>
		
		現在の画像
		<img src="${pageContext.request.contextPath}/image?name=${upProduct.fileName}" width="200">
		<input type="hidden" name="oldFileName" value="${upProduct.fileName}">
		
		<div class="field">
			商品画像変更 <input type="file" name="img" data-validate="file"> 
			<span class="error error-file is-hidden"></span>
		</div>
		<input id="vail-btu" type="submit" value="登録" disabled>
	</form>

	<a href="product-menu.jsp">商品管理画面へ戻る</a>

	<%@ include file="../tool/dialog.jsp"%>
	<script src="../js/product-edit.js"></script>
</body>
</html>