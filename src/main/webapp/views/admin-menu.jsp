<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="管理者情報画面"></c:set>
<c:set var="cssFile" value="/css/menu.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<%--  --%>
<jsp:include page="/tool/header.jsp" />

<main class="mypage">
	<section class="welcome-area">

		<h1 class="mypage-titel">
			<div class="paw-group left-pow">
				<i class="fas fa-paw pow1"></i> <i class="fas fa-paw left-pow2"></i>
				<i class="fas fa-paw pow3"></i>
			</div>
			管理者 画面
			<div class="paw-group">
				<i class="fas fa-paw pow1"></i> <i class="fas fa-paw pow2"></i> <i
					class="fas fa-paw pow3"></i>
			</div>
		</h1>

		<h3>
			<c:out value="ようこそ${user.getLastName()}さん!"></c:out>
		</h3>

		<div class="button-area">
			<button type="button" onclick="location.href = 'Product.action'">商品管理画面へ</button>
			<button type="button" onclick="location.href = 'admin-edit.jsp'">管理者情報の編集</button>
		</div>



	</section>

	<section class="member-card">

		<h2>
			<i class="fas fa-paw paw4"></i>管理者情報
		</h2>

		<table>
			<tr>
				<th>名前</th>
				<td>${user.lastName}${user.firstName}</td>
			</tr>

			<tr>
				<th>住所</th>
				<td>${user.address}</td>
			</tr>

			<tr>
				<th>メール</th>
				<td>${user.mailAddress}</td>
			</tr>
		</table>

	</section>

	<div class="button-area">
		<button class="btu-logout" type="button" id="logout">ログアウト</button>
		<button class="btu-delete" type="button" onclick="location.href = 'admin-delete.jsp'">管理者情報の削除</button>
	</div>
</main>
<%@ include file="../tool/dialog.jsp"%>

<script src="../js/logoutJs.js"></script>
</body>
</html>