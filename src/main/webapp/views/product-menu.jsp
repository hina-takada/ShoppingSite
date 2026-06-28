<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="商品管理画面"></c:set>
<c:set var="cssFile" value="/css/product-menu.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>

<jsp:include page="/tool/header.jsp" />

<main class="product">

	<h1 class="product__title">
		<div class="paw-group left-pow">
			<i class="fas fa-paw pow1"></i> <i class="fas fa-paw left-pow2"></i>
			<i class="fas fa-paw pow3"></i>
		</div>
		商品管理
		<div class="paw-group">
			<i class="fas fa-paw pow1"></i> <i class="fas fa-paw pow2"></i> <i
				class="fas fa-paw pow3"></i>
		</div>
	</h1>
	
	<button class="form-action__button register-button"  type="button" id="logout"
		onclick="location.href = 'product-add.jsp'">＋ 商品登録</button>


<nav class="pagination">

		<c:if test="${currentPage > 1}">
			<a href="Product.action?page=${currentPage - 1}">＜</a>
		</c:if>

		<c:forEach var="i" begin="1" end="${totalPages}">
			<c:choose>

				<c:when test="${i == currentPage}">
					<strong class="pagination__current">${i}</strong>
				</c:when>

				<c:otherwise>
					<a href="Product.action?page=${i}">${i}</a>
				</c:otherwise>

			</c:choose>
		</c:forEach>

		<c:if test="${currentPage < totalPages}">
			<a href="Product.action?page=${currentPage + 1}">＞</a>
		</c:if>
	</nav>


	<section class="product-list">


		<c:forEach var="product" items="${products}">

			<div class="product-list__item">

				<div class="product-card">

					<div class="product-card__image">

						<img alt="商品画像"
							src="${pageContext.request.contextPath}/image?name=${product.fileName}"
							width="200">

					</div>

					<div class="product-card__body">


						<h2 class="product-card__name">

							<c:out value="${product.name}" />

						</h2>

						<div class="product-card__info">

							<p>
								ID：
								<c:out value="${product.productId}" />
							</p>

							<p>
								カテゴリ：
								<c:out value="${product.categoryName}" />
							</p>


							<p>
								肉球：
								<c:out value="${product.pawName}" />
							</p>


							<p>
								価格：
								<c:out value="${product.price}" />
								円
							</p>


							<p>
								在庫：
								<c:out value="${product.stock}" />
								個
							</p>

							<p class="product-card__label">説明</p>

							<p class="product-card__description">

								<c:out value="${product.description}" />

							</p>



							<p class="product-card__label">肉球の感触</p>

							<p class="product-card__description">

								<c:out value="${product.pawDescription}" />

							</p>


						</div>

						<div class="product-card__button">

							<form action="ProductNextEdit.action" method="post">
								<input type="hidden" name="productId"
									value="${product.productId}"> <input type="hidden"
									name="categoryName" value="${product.categoryId}"> <input
									type="hidden" name="powId" value="${product.pawId}">
								<button class="form-action__button form-action__edit" type="submit" name="model"
									value="edit">編集</button>
							</form>

							<form action="ProductNextEdit.action" method="post">
								<input type="hidden" name="productId"
									value="${product.productId}">
								<button class="form-action__button form-action__delete" type="submit" name="model"
									value="delete">削除</button>
							</form>

						</div>
					</div>
				</div>
			</div>

		</c:forEach>

	</section>

	<!-- ページング -->

	<nav class="pagination">

		<c:if test="${currentPage > 1}">
			<a href="Product.action?page=${currentPage - 1}">＜</a>
		</c:if>

		<c:forEach var="i" begin="1" end="${totalPages}">
			<c:choose>

				<c:when test="${i == currentPage}">
					<strong class="pagination__current">${i}</strong>
				</c:when>

				<c:otherwise>
					<a href="Product.action?page=${i}">${i}</a>
				</c:otherwise>

			</c:choose>
		</c:forEach>

		<c:if test="${currentPage < totalPages}">
			<a href="Product.action?page=${currentPage + 1}">＞</a>
		</c:if>
	</nav>


	<button class="form-action__button register-button"  type="button" id="logout"
		onclick="location.href = 'product-add.jsp'">＋ 商品登録</button>

	<a class="back-link" href="admin-menu.jsp">戻る</a>

</main>

</body>
</html>