<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- JSヘッダー --%>
<c:set var="pageTitle" value="NIKUKYKU ONRLINE STORE"></c:set>
<c:set var="cssFile" value="/css/home.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>
<%-- header用のinc --%>
<jsp:include page="/tool/header.jsp" />


<main>

	<!-- ヒーロー -->
	<section class="hero">
		<div class="hero-text">

			<h1>
				<div class="paw-group left-pow">
					<i class="fas fa-paw pow1"></i> <i class="fas fa-paw left-pow2"></i>
					<i class="fas fa-paw pow3"></i>
				</div>
				NIKUKYU ONRLINE STORE
				<div class="paw-group">
					<i class="fas fa-paw pow1"></i> <i class="fas fa-paw pow2"></i> <i
						class="fas fa-paw pow3"></i>
				</div>
			</h1>
			<p>お気に入りの肉球を見つけよう</p>
		</div>

	</section>

	<section class="product-section">


		<div class="product-header">

			<h2>商品一覧</h2>


			<div class="sort">

				<button type="button" id="sortBtu">並べ替え ▽</button>

				<div id="sortMenu" class="sort-menu">
					<a href="javascript:void(0)" onclick="sortSubmit('name')">名前順</a> <a
						href="javascript:void(0)" onclick="sortSubmit('low')">価格が安い順</a> <a
						href="javascript:void(0)" onclick="sortSubmit('high')">価格が高い順</a>
				</div>
			</div>
		</div>

		<div class="product-area">

			<!-- 左カテゴリー -->
			<form id="filterForm" action="ProductSort.action" method="get">

				<div class="category-side">

					<input type="hidden" name="sort" value="${param.sort}">

					<div class="filter-title" id="categoryTitle">動物 ▼</div>

					<div class="filter-box" id="category">

						<label><input type="checkbox" name="category" value="1"
							onchange="autoSubmit()"
							<c:forEach var="c" items="${paramValues.category}">
					<c:if test="${c == '1'}">checked</c:if>
				</c:forEach>>
							イヌ科</label> <label><input type="checkbox" name="category"
							value="2" onchange="autoSubmit()"
							<c:forEach var="c" items="${paramValues.category}">
					<c:if test="${c == '2'}">checked</c:if>
				</c:forEach>>ネコ科</label>

						<label><input type="checkbox" name="category" value="3"
							onchange="autoSubmit()"
							<c:forEach var="c" items="${paramValues.category}">
					<c:if test="${c == '3'}">checked</c:if>
				</c:forEach>>クマ科</label>

						<label><input type="checkbox" name="category" value="4"
							onchange="autoSubmit()"
							<c:forEach var="c" items="${paramValues.category}">
					<c:if test="${c == '4'}">checked</c:if>
				</c:forEach>>その他</label>

					</div>

					<div class="filter-title" id="pawTitle">肉球タイプ ▼</div>

					<div class="filter-box" id="paw-types">

						<label> <input type="checkbox" name="paws" value="1"
							onchange="autoSubmit()"
							<c:forEach var="p" items="${paramValues.paws}">
					<c:if test="${p == '1'}">checked</c:if>
				</c:forEach>>ふわふわ

						</label> <label><input type="checkbox" name="paws" value="2"
							onchange="autoSubmit()"
							<c:forEach var="p" items="${paramValues.paws}">
					<c:if test="${p == '2'}">checked</c:if>
				</c:forEach>>もちもち</label>

						<label><input type="checkbox" name="paws" value="3"
							onchange="autoSubmit()"
							<c:forEach var="p" items="${paramValues.paws}">
					<c:if test="${p == '3'}">checked</c:if>
				</c:forEach>>しっかり</label>

						<label><input type="checkbox" name="paws" value="4"
							onchange="autoSubmit()"
							<c:forEach var="p" items="${paramValues.paws}">
					<c:if test="${p == '4'}">checked</c:if>
				</c:forEach>>かため</label>

					</div>
				</div>
			</form>

			<div class="product">

				<c:forEach var="product" items="${products}">

					<a class="product-card"
						href="ProductDetail.action?id=${product.productId}"> <img
						alt="商品画像"
						src="${pageContext.request.contextPath}/image?name=${product.fileName}"
						width="200">

						<h3>
							<c:out value="${product.name}" />
						</h3>
						<p class="price">
							<c:out value="${product.price}" />
							円
						</p>
						<p class="description">
							<c:out value="${product.description}" />
						</p>

					</a>
				</c:forEach>


			</div>

		</div>

	</section>
</main>


<footer> </footer>

<script src="../js/product-sort.js"></script>
</body>
</html>