<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="未ログイン画面"></c:set>
<c:set var="cssFile" value="/css/not-logged.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
	
<jsp:include page="/tool/header.jsp" />
	
	<h1>ログイン・新規登録</h1>
	
	<p>すでに会員の方</p>
	<a href="login-in.jsp">ログイン</a>
	

	<p>はじめての方</p>
	<a href="user-add.jsp">新規アカウント登録</a>
	

</body>
</html>