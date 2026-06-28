<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="商品情報編集画面"></c:set>
<c:set var="cssFile" value="/css/product-edit.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>

	<h1>商品情報編集画面</h1>

	<form action="ProductEdit.action" method="post"
		enctype="multipart/form-data">
		<div class="field">
			<input type="hidden" name="productId" value="${upProduct.productId}">
			商品名<input type="text" name="name" value="${upProduct.name}"
				data-validate="text"> <span
				class="error error-length is-hidden"></span> <span
				class="error error-regex is-hidden"></span>
		</div>

		<div class="checkbox">
			<label><input type="radio" name="categoryId" value="1"
				data-validate="radio" ${upProduct.categoryId == 1 ? 'checked' : ''}>イヌ科</label>
			<label><input type="radio" name="categoryId" value="2"
				data-validate="radio" ${upProduct.categoryId == 2 ? 'checked' : ''}>ネコ科</label>
			<label><input type="radio" name="categoryId" value="3"
				data-validate="radio" ${upProduct.categoryId == 3 ? 'checked' : ''}>クマ科</label>
				<label><input type="radio" name="categoryId" value="3"
				data-validate="radio" ${upProduct.categoryId == 4 ? 'checked' : ''}>その他</label>
			<span class="error error-chack is-hidden"></span>
		</div>

		<div class="checkbox">
			<label><input type="radio" name="pawId" value="1"
				data-validate="radio" ${upProduct.pawId == 1 ? 'checked' : ''}>ふわふわ</label>
			<label><input type="radio" name="pawId" value="2"
				data-validate="radio" ${upProduct.pawId == 2 ? 'checked' : ''}>もちもち</label>
			<label><input type="radio" name="pawId" value="3"
				data-validate="radio" ${upProduct.pawId == 3 ? 'checked' : ''}>しっかり</label>
			<label><input type="radio" name="pawId" value="4"
				data-validate="radio" ${upProduct.pawId == 4 ? 'checked' : ''}>かため</label>
			<span class="error error-chack is-hidden"></span>
		</div>

		<div class="field">
			価格<input type="number" name="price" value="${upProduct.price}"
				min="0" data-validate="number"> <span
				class="error error-num is-hidden"></span>
		</div>

		<div class="field">
			在庫数<input type="number" name="stock" value="${upProduct.stock}"
				min="0" max="9999" data-validate="number"> <span
				class="error error-num is-hidden"></span>
		</div>

		<div class="field">
			<p>商品説明</p>
			<textarea name="description" rows="10" cols="70" data-validate="text"><c:out value="${upProduct.description}"></c:out></textarea>
			<span class="error error-length is-hidden"></span>
		</div>


		現在の画像 <img
			src="${pageContext.request.contextPath}/image?name=${upProduct.fileName}"
			width="200"> <input type="hidden" name="oldFileName"
			value="${upProduct.fileName}">

		<div class="field">
			商品画像変更 <input type="file" name="img" data-validate="file"> <span
				class="error error-file is-hidden"></span>
		</div>
		<input id="vail-btu" type="submit" value="登録" disabled>
	</form>

	<a href="product-menu.jsp">商品管理画面へ戻る</a>

	<%@ include file="../tool/dialog.jsp"%>
	<script src="../js/product-edit.js"></script>
</body>
</html>