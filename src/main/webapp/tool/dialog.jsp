<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="ログイン画面"></c:set>
<c:set var="cssFile" value="/tool/dialog.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<%--  --%>


<!-- ダイアログ用 -->
<dialog class="confirm-dialog" id="myDialog">

<div class="dialog-body">

	<p class="dialog-massage" id="dialogMessage"></p>

	<div class="buttons">
		<button class="button button-yes" type="button" id="okBtu">はい</button>
		<button class="button button-no" type="button" id="noBtu">いいえ</button>
	</div>
</div>
</dialog>

</body>
</html>