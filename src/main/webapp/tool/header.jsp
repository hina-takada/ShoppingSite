<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value=""></c:set>
<c:set var="cssFile" value="/tool/header.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>

<header class="header">

	<div class="header-inner">

	<!-- ロゴ -->
		<div class="header-logo">
			<a href="HomeProduct.action"> 
			<img alt="ロゴ" src="../img/logo2.png">
			</a>
		</div>
		
		<!-- 検索フォーム -->
		<div class="header-serch">
		<form action="HomeSerch.action" method="get">
			<input type="text" name="keyword" value="${keyword}"> 
			<button type="submit" value="検索">
		</form>
		</div>

<!-- アイコン -->
		<div class="header-icons">
			<a href="Menu.action"><i class="fas fa-user"></i></a>
			<a href="cart.jsp"><i class="fas fa-shopping-cart"></i></a>
		</div>

		

	</div>

</header>
</body>
</html>