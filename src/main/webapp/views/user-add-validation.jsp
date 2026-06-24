<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="新規登録確認 画面"></c:set>
<c:set var="cssFile" value="/css/user-add-validation.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<%--  --%>
<main class="confirm-main">
	<h2 class="confirm-title">この内容でよろしいですか?</h2>

	<div class="confirm-box">

		<div class="confirm-row">
			<label class="form-label">会員ID</label>
			<div class="confirm-value">
				<c:out value="${insertUser.id}"></c:out>
			</div>
		</div>

		<div class="confirm-row">
			<label class="form-label">パスワード</label>
			<div class="confirm-value pass-mask">
				<c:forEach begin="1" end="${insertUser.pass.length()}">
				●
				</c:forEach>
			</div>
		</div>

		<div class="confirm-row">
			<label class="form-label">名前(姓)</label>
			<div class="confirm-value">
				<c:out value="${insertUser.lastName}"></c:out>
			</div>
		</div>

		<div class="confirm-row">
			<label class="form-label">名前(名)</label>
			<div class="confirm-value">
				<c:out value="${insertUser.firstName}"></c:out>
			</div>
		</div>

		<div class="confirm-row">
			<label class="form-label">住所</label>
			<div class="confirm-value">
				<c:out value="${insertUser.address}"></c:out>
			</div>
		</div>

		<div class="confirm-row">
			<label class="form-label">メールアドレス</label>
			<div class="confirm-value">
				<c:out value="${insertUser.mailAddress}"></c:out>
			</div>
		</div>
		
			<form class="form-action" action="Add.action" method="post">
				<button class="register-btn" type="submit">登録</button>
			</form>

		<div class="link-area">
			<a href="user-add.jsp">戻る</a>
		</div>

	</div>

	</body>
	</html>