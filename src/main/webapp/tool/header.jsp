<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<header>
		<a href="HomeProduct.action">NIKUKYKU</a>
		<%-- ログインしてなければログインか新規遷移--%>
		<a href="user-menu.jsp">マイページ</a>
		<a href="cart.jsp">カート</a>
		
		<form action="HomeSerch.action" method="get">
		 <input type="text" name="keyword" value="${keyword}">
		 <input type="submit" value="検索">
		</form>
	</header>
</body>
</html>