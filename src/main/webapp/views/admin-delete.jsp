<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="管理者削除確認 画面"></c:set>
<c:set var="cssFile" value="/css/delete.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<main class="delete-main">
	<div class="warning-box">
		<p>以下の管理者情報を削除します。</p>

		<table>
			<tr>
				<th>氏名</th>
				<td>${user.lastName}${user.firstName}</td>
			</tr>
			<tr>
				<th>ID</th>
				<td>${user.id}</td>
			</tr>
		</table>

		<p class="warning-message">※削除したデータは元に戻せません。 ※履歴も削除され見れません。</p>
	</div>

	<div class="button-area">
		<form  action="Delete.action" method="post">
			<button class="delete-btn" type="submit" name="model" value="admin">
			削除する
			</button>
		</form>

		<button class="cancel-btn" type="button" onclick="location.href = 'admin-menu.jsp'">
			キャンセル
		</button>
		
	</div>
</main>

</body>
</html>