<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="会員編集確認画面"></c:set>
<c:set var="cssFile" value="/css/user-add-validation.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>

<main class="confirm-main">
	<h2 class="confirm-title">編集する内容はこちらでよろしいですか？</h2>

	<div class="confirm-box">

		<div class="confirm-row">
			<label class="form-label">会員ID:</label>
			<div class="confirm-value">
				<c:out value="${upUser.id}"></c:out>
			</div>
		</div>

		<div class="confirm-row">
			<label class="form-label">パスワード</label>
			<div class="confirm-value pass-mask">
				<c:forEach begin="1" end="${upUser.pass.length()}">
				●
				</c:forEach>
			</div>
		</div>

		<div class="confirm-row">
			<label class="form-label"> 名前(姓)</label>
			<div class="confirm-value">
				<c:out value="${upUser.lastName}"></c:out>
			</div>
		</div>

		<div class="confirm-row">
			<label class="form-label">名前(名)</label>
			<div class="confirm-value">
				<c:out value="${upUser.firstName}"></c:out>
			</div>
		</div>

		<div class="confirm-row">
			<label class="form-label">住所</label>
			<div class="confirm-value">
				<c:out value="${upUser.address}"></c:out>
			</div>
		</div>

		<div class="confirm-row">
			<label class="form-label">メールアドレス</label>
			<div class="confirm-value">
				<c:out value="${upUser.mailAddress}"></c:out>
			</div>
		</div>

		<form class="form-action" action="Edit.action" method="post">
			<button class="register-btn" type="submit" type="submit" name="model"
				value="user">登録</button>
		</form>

		<div class="link-area">
			<a href="user-edit.jsp">戻る</a>
		</div>

	</div>
</main>

</body>
</html>