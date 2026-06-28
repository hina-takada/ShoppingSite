<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="商品削除確認 画面"></c:set>
<c:set var="cssFile" value="/css/delete.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<main class="delete-main">
	<div class="warning-box">
		<p>以下の商品を削除します。</p>

		<table>
			<tr>
				<th>商品名</th>
				<td>"${upProduct.name}</td>
			</tr>
			<tr>
				<th>科目名</th>
				<td>${upProduct.categoryName}</td>
			</tr>
		</table>

		<p class="warning-message">※削除したデータは元に戻せません</p>
	</div>


	<div class="button-area">
		<form action="ProductDelete.action" method="post">
			<button class="delete-btn" type="submit">削除する</button>
		</form>
		
		<button class="cancel-btn" type="button" onclick="location.href = 'product-menu.jsp'">いいえ</button>
	
	</div>
</main>

</body>
</html>