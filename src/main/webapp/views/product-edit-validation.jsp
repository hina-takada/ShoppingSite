<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品編集画面</title>
</head>
<body>
	<h2>編集する内容はこちらでよろしいですか？</h2>
	<c:out value="${upProduct.productId}"></c:out>
	商品名：<c:out value="${upProduct.name}"></c:out><br>
	カテゴリー名：<c:out value="${upProduct.categoryName}"></c:out><br>
	価格<c:out value="${upProduct.price}"></c:out><br>
	在庫数：<c:out value="${upProduct.count}"></c:out><br>
	商品説明：<c:out value="${upProduct.description}"></c:out><br>
	
	<form action="ProductEdit.action" method="post">
		<button type="submit">登録</button>
	</form>
	
	 <button type="button" onclick="location.href='product-edit.jsp'">
	  戻る
	 </button>
	
</body>
</html>