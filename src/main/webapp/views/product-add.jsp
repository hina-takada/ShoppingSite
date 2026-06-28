<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="pageTitle" value="商品登録"></c:set>
<c:set var="cssFile" value="/css/product-add.css"></c:set>
<%@ include file="../tool/js-header.jsp"%>


<main class="add-main">


	<h2 class="add-title">

		<div class="paw-group">
			<i class="fas fa-paw pow1"></i> <i class="fas fa-paw pow2"></i> <i
				class="fas fa-paw pow3"></i>
		</div>

		商品登録

		<div class="paw-group">
			<i class="fas fa-paw pow1"></i> <i class="fas fa-paw pow2"></i> <i
				class="fas fa-paw pow3"></i>
		</div>

	</h2>



	<form class="add-form" action="ProductAdd.action" method="post"
		enctype="multipart/form-data" autocomplete="off">



		<div class="field">

			<label class="form-label"> 商品名 </label> <input type="text"
				name="name" placeholder="商品名" data-validate="text"> <span
				class="error error-length is-hidden"></span> <span
				class="error error-regex is-hidden"></span>


		</div>





		<div class="checkbox">


			<label class="form-label"> カテゴリ </label>


			<div class="radio-group">


				<label> <input type="radio" name="categoryId" value="1"
					data-validate="radio"> イヌ科

				</label> <label> <input type="radio" name="categoryId" value="2"
					data-validate="radio"> ネコ科

				</label> <label> <input type="radio" name="categoryId" value="3"
					data-validate="radio"> クマ科

				</label>
				
				 <label> <input type="radio" name="categoryId" value="4"
					data-validate="radio">その他

				</label>


			</div>


			<span class="error error-chack is-hidden"></span>


		</div>






		<div class="checkbox">


			<label class="form-label"> 肉球の感触 </label>


			<div class="radio-group">


				<label> <input type="radio" name="pawId" value="1"
					data-validate="radio"> ふわふわ

				</label> <label> <input type="radio" name="pawId" value="2"
					data-validate="radio"> もちもち

				</label> <label> <input type="radio" name="pawId" value="3"
					data-validate="radio"> しっかり

				</label> <label> <input type="radio" name="pawId" value="4"
					data-validate="radio"> かため

				</label>


			</div>


			<span class="error error-chack is-hidden"></span>


		</div>






		<div class="field">


			<label class="form-label"> 価格 </label> <input type="number"
				name="price" placeholder="10000" data-validate="number"> <span
				class="error error-num is-hidden"></span>


		</div>






		<div class="field">


			<label class="form-label"> 在庫数 </label> <input type="number"
				name="stock" placeholder="1" data-validate="number"> <span
				class="error error-num is-hidden"></span>


		</div>







		<div class="field">


			<label class="form-label"> 商品説明 </label>


			<textarea name="description" data-validate="text" placeholder="商品の説明"></textarea>


			<span class="error error-length is-hidden"></span>


		</div>







		<div class="field">


			<label class="form-label"> 商品画像 </label> <input type="file"
				name="img" data-validate="file"> <span
				class="error error-file is-hidden"></span>


		</div>







		<div class="form-action">


			<input id="vali-btu" type="submit" value="登録" disabled>


		</div>




	</form>






	<div class="link-area">

		<a href="product-menu.jsp"> 商品管理へ戻る </a>


	</div>



</main>



<%@ include file="../tool/dialog.jsp"%>

<script src="../js/product-add.js"></script>


</body>
</html>