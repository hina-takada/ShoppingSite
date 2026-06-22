<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="新規会員登録 画面"></c:set>
<c:set var="cssFile" value="/css/user-add.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<%--  --%>

<main class="add-main">

		<h2 class="add-title">会員情報登録</h2>

		<form class="add-form" action="AddValidation.action" method="post" autocomplete="off">
			
			<div class="field">
				<!-- 半角英数文字 -->
				<label class="form-label">会員ID<span>*</span></label>
				<input type="text" name="id" placeholder="ID入力"
					value="${insertUser.id}" autocomplete="off"> <span
					class="error error-length is-hidden"></span> <span
					class="error error-id is-hidden"></span>
			</div>
			
			<!-- 半角英数文字 -->
			<div class="field">
				<label class="form-label">パスワード<span>*</span></label>
				<input type="text" name="pass" placeholder="パスワード入力"
					value="${insertUser.pass}" autocomplete="new-password"> <span
					class="error error-length is-hidden"></span>
			</div>
			
			<div class="field">
				<label class="form-label">名前(姓)<span>*</span></label>
				<input type="text" name="lastName" placeholder="例:山田"
					value="${insertUser.lastName}"> <span
					class="error error-length is-hidden"></span>
			</div>
			
			<div class="field">
				<label class="form-label">名前(名)<span>*</span></label>
				<input type="text" name="firstName" placeholder="例:太郎"
					value="${insertUser.firstName}"> <span
					class="error error-length is-hidden"></span>
			</div>
			
			<div class="field">
				<label class="form-label">住所<span>*</span></label>
				<input type="text" name="address" placeholder="○○県○○市○○XXXX-XX"
					value="${insertUser.address}"> <span
					class="error error-length is-hidden"></span>
			</div>
			
			<div class="field">
				<label class="form-label">メールアドレス<span>*</span></label>
				<input type="email" name="mailAddress"
					placeholder="○○○○@mail.com" value="${insertUser.mailAddress}">
				<span class="error error-length is-hidden"></span>
			</div>
			
			<div class="form-action">
			<input id="vali-btu" type="submit" value="確認画面へ" disabled>
			</div>
		
		</form>
		
		<div class="link-area">
		<a href="login-in.jsp">ログイン画面へ戻る</a>
		</div>
</main>

<script src="../js/user-add.js"></script>
</body>
</html>