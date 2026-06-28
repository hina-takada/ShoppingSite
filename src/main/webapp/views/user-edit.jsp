<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="会員情報編集画面"></c:set>
<c:set var="cssFile" value="/css/user-add.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>

<main class="add-main">

	<h2 class="add-title">
		<div class="paw-group left-pow">
			<i class="fas fa-paw pow1"></i> <i class="fas fa-paw left-pow2"></i>
			<i class="fas fa-paw pow3"></i>
		</div>
		会員情報編集画面
		<div class="paw-group">
			<i class="fas fa-paw pow1"></i> <i class="fas fa-paw pow2"></i> <i
				class="fas fa-paw pow3"></i>
		</div>
	</h2>

	<form class="add-form" action="EditValidation.action" method="post">

		<div class="field">
			<label class="form-label">会員ID<span>*</span></label> <input
				type="text" name="id" autocomplete="off"
				value="${empty upUser ? user.id : upUser.id}"> <input
				type="hidden" id="current-id" value="${user.id}"> <span
				class="error error-length is-hidden"></span> <span
				class="error error-id is-hidden"></span>
		</div>

		<div class="field">
			<label class="form-label">パスワード<span>*</span></label>
			<div class="pass_box">
				<input id="pass" type="password" name="pass"
					autocomplete="new-password"
					value="${empty upUser ? user.pass : upUser.pass}"> <i
					id="pass-eye" class="fas fa-eye" aria-hidden="true"></i>
			</div>
			<span class="error error-length is-hidden"></span> <span
				class="error error-id is-hidden"></span>
		</div>

		<div class="field">
			<label class="form-label">パスワード確認<span>*</span></label>
			<div class="pass_box">
				<input id="passConfirm" type="password" name="passConfirm"
					placeholder="もう一度パスワード入力" value="${empty upUser ? user.pass : upUser.passConfirm}"
					autocomplete="new-password"> <i id="confirm-eye"
					class="fas fa-eye" aria-hidden="true"></i>
			</div>
			<span class="error error-length is-hidden"></span>
		</div>

		<div class="field">
			<label class="form-label">名前(姓)<span>*</span></label> <input
				type="text" name="lastName"
				value="${empty upUser ? user.lastName : upUser.lastName}"> <span
				class="error error-length is-hidden"></span>
		</div>


		<div class="field">
			<label class="form-label">名前(名)<span>*</span> <input
				type="text" name="firstName"
				value="${empty upUser ? user.firstName : upUser.firstName}">
				<span class="error error-length is-hidden"></span>
		</div>


		<div class="field">
			<label class="form-label">住所<span>*</span></label> <input type="text"
				name="address"
				value="${empty upUser ? user.address : upUser.address}"> <span
				class="error error-length is-hidden"></span>
		</div>

		<div class="field">
			<label class="form-label">メールアドレス<span>*</span></label> <input
				type="text" name="mailAddress"
				value="${empty upUser ? user.mailAddress : upUser.mailAddress}">
			<span class="error error-length is-hidden"></span>
		</div>

		<div class="form-action">
			<button id="vali-btu" type="submit" name="model" value="name" disabled>
			確認
			</button>
		</div>

	</form>

	<div class="link-area">
		<a href="user-menu.jsp">マイページへ戻る</a>
	</div>

</main>

<script src="../js/user-edit.js"></script>
</body>
</html>