<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="会員情報画面"></c:set>
<c:set var="cssFile" value="/css/menu.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<%--  --%>

</head>
<body>

	<jsp:include page="/tool/header.jsp" />

	<main class="mypage">
		<section class="welcome-area">
			<h1 class="mypage-titel">
				<div class="paw-group left-pow">
					<i class="fas fa-paw pow1"></i> <i class="fas fa-paw left-pow2"></i>
					<i class="fas fa-paw pow3"></i>
				</div>
				マイページ
				<div class="paw-group">
					<i class="fas fa-paw pow1"></i> <i class="fas fa-paw pow2"></i> <i
						class="fas fa-paw pow3"></i>
				</div>
			</h1>

			<p>
				ようこそ
				<c:out value="${user.getLastName()}さん"></c:out>
			</p>

		</section>

		<section class="member-card">

			<h2>
				<i class="fas fa-paw paw4"></i>会員情報
			</h2>

			<table>
				<tr>
					<th>名前</th>
					<td>${user.lastName}${user.firstName}</td>
				</tr>

				<tr>
					<th>住所</th>
					<td>${user.address}</td>
				</tr>

				<tr>
					<th>メール</th>
					<td>${user.mailAddress}</td>
				</tr>
			</table>

		</section>


		<div class="button-area">
			<button type="button" onclick="location.href = 'user-edit.jsp'">会員情報を編集</button>
		</div>

		<section class="history-section">

			<h2>
				<i class="fas fa-paw paw4"></i>ご注文履歴
			</h2>
			<c:if test="${empty historyMap}">
				<div class="not-history">
					<p>ご注文履歴はございません</p>
				</div>
			</c:if>

			<c:if test="${not empty historyMap}">

				<c:forEach var="dateEntry" items="${historyMap}">

					<!-- 日付全体 -->
					<div class="date-box">

						<!-- 日付 -->
						<div class="order-date">${dateEntry.key}</div>

						<c:forEach var="timeEntry" items="${dateEntry.value}">
							<!-- 時間ごとの箱 -->
							<div class="time-box">

								<!-- 商品一覧 -->
								<div class="order-card">

									<!-- 時間 -->
									<%-- <div class="order-time">${timeEntry.key}</div> --%>


									<c:forEach var="history" items="${timeEntry.value}">

										<div class="product-row">
											<img alt="商品画像"
												src="${pageContext.request.contextPath}/image?name=${history.product.fileName}"
												width="200">

											<div class="product-info">

												<h4>
													<c:out value="商品名：${history.product.name}"></c:out>
												</h4>

												<p>
													価格：
													<c:out value="￥${history.product.price}"></c:out>
												</p>

												<p>
													個数：
													<c:out value="${history.count}"></c:out>
												</p>

												<p>
													<c:out value="小計：${history.subTotal}"></c:out>
												</p>

											</div>
										</div>
									</c:forEach>

									<!-- 合計情報 -->
									<c:set var="hist" value="${timeEntry.value[0]}" />

									<div class="total-area">
										<p>
											消費税
											<c:out value="${hist.tax}" />
										</p>

										<p>
											税込み
											<c:out value="${hist.totalTax}" />
										</p>

										<p>
											送料： ¥
											<c:out value="${hist.shippingFee}" />
										</p>

										<p class="grand-total">
											合計： ¥
											<c:out value="${hist.grandTotal}" />
										</p>

									</div>
								</div>
						</c:forEach>

						<%-- <c:out value="名前_姓：${history.user.lastName}"></c:out>
								<c:out value="名前_名：${history.user.firstName}"></c:out>
							<c:out value="住所：${history.user.address}"></c:out> --%>
					</div>
				</c:forEach>
			</c:if>
		</section>

		<div class="button-area">
			<button class="btu-logout" type="button" id="logout">ログアウト</button>
			<button class="btu-delete" type="button"
				onclick="location.href = 'user-delete.jsp'">会員情報を削除</button>
		</div>

	</main>
	<%@ include file="../tool/dialog.jsp"%>

	<script src="../js/logoutJs.js"></script>
</body>
</html>