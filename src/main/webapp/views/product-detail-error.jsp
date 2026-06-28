<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="商品管理エラー画面"></c:set>
<c:set var="cssFile" value="/css/error.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>

<div class="error-main">

<h2 class="error-title">画面遷移エラー</h2>
<main class="error-card">

	<img src="../img/error_img.jpg">

	<div class="error-text">
		<p>商品詳細画面に遷移できませんでした</p>


		<div class="back-link">
			<span class="icon"> <i class="fas fa-arrow-right"></i>
			</span><a href="HomeProduct.action">ホーム画面へ戻る</a>
		</div>
	</div>

</main>
</div>

</body>
</html>