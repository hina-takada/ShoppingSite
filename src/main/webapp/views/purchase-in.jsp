<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="購入手続き画面"></c:set>
<c:set var="cssFile" value="/css/purchase.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<%-- header用のinc --%>

<main class="purchase">

	<h1 class="purchase__title">


		<span class="paw-group"> <i class="fas fa-paw pow1"></i> <i
			class="fas fa-paw pow2"></i> <i class="fas fa-paw pow3"></i>
		</span> 購入手続き <span class="paw-group"> <i class="fas fa-paw pow1"></i>
			<i class="fas fa-paw pow2"></i> <i class="fas fa-paw pow3"></i>
		</span>


	</h1>





	<section class="purchase-products">


		<c:forEach var="item" items="${cart}">


			<div class="purchase-card">


				<img
					src="${pageContext.request.contextPath}/image?name=${item.product.fileName}"
					alt="商品画像">

				<div class="purchase-card__info">

					<h2>
						<c:out value="${item.product.name}" />
					</h2>


					<p>

						個数：
						<c:out value="${item.count}" />

					</p>


					<p class="price">

						¥
						<c:out value="${item.subTotal}" />

					</p>


				</div>


			</div>



		</c:forEach>


	</section>





	<section class="purchase-total">


		<div class="purchase-subtotal">

			<p>

				小計：
				<c:out value="${cart.size()}" />
				アイテム

			</p>


			<p>

				¥
				<c:out value="${totalTax}" />

			</p>

		</div>




		<div class="purchase-final">


			<p>

				送料：
				<c:out value="${SHIPPING_FEE}" />

			</p>


			<h2>

				合計：
				<c:out value="${grandTotal}" />

			</h2>

		</div>


	</section>







	<section class="purchase-form">


		<form action="Purchases.action" method="post">


			<label> お名前_姓 </label> <input id="buy-lastname" type="text"
				name="last-name" value="${user.getLastName()}"> <span
				id="error-msg-lastname" class="errorMsg"> </span> <label>
				お名前_名 </label> <input id="buy-firstname" type="text" name="first-name"
				value="${user.getFirstName()}"> <span
				id="error-msg-firstname" class="errorMsg"> </span> <label>
				ご住所 </label> <input id="buy-address" type="text" name="address"
				value="${user.getAddress()}"> <span id="error-msg-address"
				class="errorMsg"> </span> 
				
				<input class="purchase-button"
				type="submit" value="購入を確定" disabled>


		</form>


		<a class="back-cart" href="cart.jsp"> カートに戻る </a>



	</section>



</main>


<%@ include file="../tool/dialog.jsp"%>

<script src="../js/purchases.js"></script>


</body>
</html>