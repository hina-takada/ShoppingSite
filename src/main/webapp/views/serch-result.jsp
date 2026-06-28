<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="検索結果画面"></c:set>
<c:set var="cssFile" value="/css/serch.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<%-- header用のinc --%>
<jsp:include page="/tool/header.jsp" />

<main class="search-result">

	<h1 class="search-title">
		<div class="paw-group ">
			<i class="fas fa-paw pow1"></i> 
			<i class="fas fa-paw pow2"></i>
			<i class="fas fa-paw pow3"></i>
		</div>
		検索結果
		<div class="paw-group">
			<i class="fas fa-paw pow1"></i>
			 <i class="fas fa-paw left-pow2"></i>
			<i class="fas fa-paw pow3"></i>
		</div>
	</h1>

	<!-- 検索してなかったら表示する -->
	<c:if test="${empty products }">
		<p class="search-result__empty">検索された商品はありません</p>
	</c:if>



	<c:if test="${not empty products }">

		<div class="search-result__content">

			<div class="product">

				<c:forEach var="product" items="${products}">

					<a href="ProductDetail.action?id=${product.productId}"
						class="product-card"> <img
						src="${pageContext.request.contextPath}/image?name=${product.fileName}"
						alt="商品画像">

						<div class="product-card__body">

							<h3>
								<c:out value="${product.name}" />
							</h3>

							<p class="description">
								<c:out value="${product.description}" />
							</p>

							<p class="price">
								¥
								<c:out value="${product.price}" />
								<span>(税抜き)</span>
							</p>


						</div>

					</a>

				</c:forEach>

			</div>

		</div>
		<footer> </footer>

	</c:if>
</main>

<script src="../js/home.js"></script>
</body>
</html>