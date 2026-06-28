<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="pageTitle" value="カート画面"></c:set>
<c:set var="cssFile" value="/css/cart.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>

<jsp:include page="/tool/header.jsp" />

<main class="cart">


	<h1 class="cart__title">

		<span class="paw-group"> <i class="fas fa-paw pow1"></i> <i
			class="fas fa-paw pow2"></i> <i class="fas fa-paw pow3"></i>
		</span> カート <span class="paw-group"> <i class="fas fa-paw pow1"></i> <i
			class="fas fa-paw pow2"></i> <i class="fas fa-paw pow3"></i>
		</span>

	</h1>

	<c:choose>


		<c:when test="${cart.size() > 0}">


			<div class="cart-list">


				<c:forEach var="item" items="${cart}">


					<div class="cart-card">


						<img
							src="${pageContext.request.contextPath}/image?name=${item.product.fileName}"
							alt="商品画像">


						<div class="cart-card__info">


							<h2>
								<c:out value="${item.product.name}" />
							</h2>


							<p class="price">

								¥
								<c:out value="${item.product.price}" />

							</p>



							<p class="description">

								<c:out value="${item.product.description}" />

							</p>




							<div class="cart-count">


								<a
									href="CartCount.action?id=${item.product.productId}&type=minus">
									− </a> <span> <c:out value="${item.count}" />
								</span> <a
									href="CartCount.action?id=${item.product.productId}&type=plus">
									＋ </a>


							</div>



							<p class="subtotal">

								小計： ¥
								<c:out value="${item.subTotal}" />
								円

							</p>



							<a class="delete"
								href="CartRemove.action?id=${item.product.productId}"> 削除 </a>


						</div>


					</div>


				</c:forEach>


			</div>





			<div class="cart-total">

				<div class="cart-total__content">
					<p>
						消費税：
						<c:out value="${tax}" />
						円
					</p>


					<h2>

						合計：
						<c:out value="${totalTax}" />
						円

					</h2>


					<p>送料は購入手続き時に計算されます</p>


					<form action="purchase-in.jsp" method="post">

						<input type="hidden" name="fromCart" value="true">


						<button>購入手続き</button>


					</form>



					<a href="HomeProduct.action"> 買い物を続ける </a>
				</div>

			</div>



		</c:when>





		<c:otherwise>


			<div class="cart-empty">


				<p>カートに商品がありません</p>


				<a href="HomeProduct.action"> ホーム画面へ戻る </a>


			</div>


		</c:otherwise>


	</c:choose>


</main>


</body>
</html>