const buyFirstName = document.getElementById("buy-firstname");
const buyLastName = document.getElementById("buy-lastname");
const buyAddress = document.getElementById("buy-address");
const errorMsgFName = document.getElementById("error-msg-firstname");
const errorMsgLName = document.getElementById("error-msg-lastname");
const errorMsgAddress = document.getElementById("error-msg-address");

const purchaseButton = document.querySelector(".purchase-button");

function valideteInput(input, errorMsg, min, max, regex) {
	const value = input.value;
	const length = value.length;

	if (length == 0) {
		errorMsg.textContent = "入力してださい";
		errorMsg.style.display = "block";
		return false;
	}

	if (!regex.test(value)) {
		errorMsg.textContent = "使用できない文字が含まれています";
		errorMsg.style.display = "block";
		return false;
	}

	if (length < min || length > max) {
		errorMsg.textContent = `${min}～${max}文字以内で入力してください`;
		errorMsg.style.display = "block";
		return false;
	}

	//OK
	errorMsg.style.display = "none";
	return true;
}

function updatebuy() {

	const lastNameCheck = valideteInput(
		buyLastName,
		errorMsgLName,
		1,
		32,
		/^[ぁ-んァ-ヶ一-龠々A-Za-z]+$/
	);

	const firstNameCheck = valideteInput(
		buyFirstName,
		errorMsgFName,
		1,
		32,
		/^[ぁ-んァ-ヶ一-龠々A-Za-z]+$/
	);

	const addressCheck = valideteInput(
		buyAddress,
		errorMsgAddress,
		1,
		128,
		/^[^<>]+$/
	);


	const result = lastNameCheck && firstNameCheck && addressCheck;


	// OKなら押せる
	purchaseButton.disabled = !result;


	return result;
}

buyLastName.addEventListener("input", updatebuy);
buyFirstName.addEventListener("input", updatebuy);
buyAddress.addEventListener("input", updatebuy);


window.addEventListener("DOMContentLoaded", () => {
	updatebuy();
});



/* ダイヤログ */
/* ダイアログ */

const form = document.querySelector(".purchase-form form");

const dialog = document.getElementById("myDialog");
const message = document.getElementById("dialogMessage");

const okBtu = document.getElementById("okBtu");
const noBtu = document.getElementById("noBtu");


form.addEventListener("submit", function(e) {


	// 入力チェック
	if (!updatebuy()) {

		e.preventDefault();

		return;

	}


	// 送信停止
	e.preventDefault();


	message.textContent =
		"購入を確定します。よろしいですか？";


	dialog.showModal();


});



noBtu.addEventListener("click", function() {

	dialog.close();

});



okBtu.addEventListener("click", function() {

	form.submit();

});

