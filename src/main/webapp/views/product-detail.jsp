<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="商品詳細画面"></c:set>
<c:set var="cssFile" value="/css/product-detail.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<%-- header用のinc --%>
<jsp:include page="/tool/header.jsp" />

<main class="product-detail">


	<h1 class="product-detail__title">

		<span class="paw-group"> <i class="fas fa-paw pow1"></i> <i
			class="fas fa-paw pow2"></i> <i class="fas fa-paw pow3"></i>
		</span> 商品詳細 <span class="paw-group"> <i class="fas fa-paw pow1"></i>
			<i class="fas fa-paw pow2"></i> <i class="fas fa-paw pow3"></i>
		</span>

	</h1>



	<section class="product-detail__card">


		<div class="product-detail__image">


			<img alt="商品画像"
				src="${pageContext.request.contextPath}/image?name=${product.fileName}">


		</div>




		<div class="product-detail__info">


			<h2>
				<c:out value="${product.name}" />
			</h2>



			<p class="category">

				<c:out value="${product.categoryName}" />

				/

				<c:out value="${product.pawName}" />

			</p>




			<p class="price">

				¥
				<c:out value="${product.price}" />

				<span>(税抜き)</span>

			</p>



			<p class="description">

				<c:out value="${product.description}" />

			</p>




			<c:if test="${product.stock > 0}">


				<form action="CartAdd.action" method="get" class="cart-form">


					<select name="count">

						<c:forEach var="i" begin="1" end="10">

							<option value="${i}">${i}</option>

						</c:forEach>

					</select> <input type="hidden" name="id" value="${product.productId}">



					<button type="submit">カートに追加</button>


				</form>


			</c:if>



			<c:if test="${product.stock == 0}">

				<button disabled class="stock-none">在庫切れ</button>


			</c:if>


		</div>


	</section>


</main>
</body>
</html>