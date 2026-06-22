/* =========================
   要素取得
========================= */
const textFields = document.querySelectorAll(
	"input[data-validate]:not([type='radio']):not([type='file']), textarea[data-validate]"
);

const radioFields = document.querySelectorAll(
	"input[type='radio'][data-validate]"
);

const fileField = document.querySelector(
	"input[type='file'][data-validate]"
);

const submitBtn = document.getElementById("vail-btu");

console.log(document.querySelector("textarea").value);

/* =========================
   ルール
========================= */
const rules = {
	name: {
		min: 1,
		max: 100,
		regex: /^[ぁ-んァ-ヶー一-龠々A-Za-z]+$/,
		message: "使用できない文字が含まれています"
	},
	price: {
		min: 1000,
		max: 999999,
		message: "数字を入力してください"
	},
	count: {
		min: 0,
		max: 9999,
		message: "数字を入力してください"
	},
	description: {
		min: 1,
		max: 200,
		message: ""
	}
};


/* =========================
   エラー表示
========================= */
function showError(input, selector, msg) {
	const el = input.parentElement.querySelector(selector);
	if (!el) return;
	el.textContent = msg;
	el.classList.remove("is-hidden");
}

function hideError(input, selector) {
	const el = input.parentElement.querySelector(selector);
	if (!el) return;
	el.textContent = "";
	el.classList.add("is-hidden");
}


/* =========================
   メインバリデーション
========================= */
function validate(field) {

	const type = field.dataset.validate;
	const rule = rules[field.name];
	const value = field.value;

	if (!rule) return true;

	switch (type) {
		case "text":
			return validateText(field, rule, value);

		case "number":
			return validateNumber(field, rule, value);

		default:
			return true;
	}
}


/* ----- text ----- */
function validateText(field, rule, value) {

	if (!value) return false;

	if (value.length < rule.min || value.length > rule.max) {
		showError(field, ".error-length",
			`${rule.min}～${rule.max}の範囲で入力してください`
		);
		return false;
	}

	if (rule.regex && !rule.regex.test(value)) {
		showError(field, ".error-regex", rule.message);
		return false;
	}

	hideError(field, ".error-length");
	if (rule.regex) hideError(field, ".error-regex");

	return true;
}


/* ----- number ----- */
function validateNumber(field, rule, value) {

	if (!value) return false;

	if (!/^[0-9]+$/.test(value)) {
		showError(field, ".error-num", rule.message);
		return false;
	}

	const num = Number(value);

	if (num < rule.min || num > rule.max) {
		showError(field, ".error-num",
			`${rule.min}～${rule.max}の範囲で入力してください`
		);
		return false;
	}

	hideError(field, ".error-num");
	return true;
}


/* ----- file ----- 
function validateFile(field) {
	if (!field.files || field.files.length === 0) {
		showError(field, ".error-file", "画像を選択してください");
		return false;
	}

	const file = field.files[0];

	const validTypes = ["image/jpeg", "image/png", "image/webp"];

	if (!validTypes.includes(file.type)) {
		showError(field, ".error-file", "画像ファイルを選択してください");
		return false;
	}

	hideError(field, ".error-file");
	return true;
}*/


/* =========================
   radioバリデーション
========================= */
function validateRadio(name) {

	const checked = document.querySelector(
		`input[name="${name}"]:checked`
	);

	const error = document.querySelector(".error-chack");

	if (checked) {
		error.textContent = "";
		error.classList.add("is-hidden");
		return true;
	}

	error.textContent = "選択してください";
	error.classList.remove("is-hidden");

	return false;
}


/* =========================
   ボタン制御
========================= */
function updateButton() {

	const textValid = [...textFields]
		.every(f => validate(f));

	const radioValid = validateRadio("categoryId");

	/*//
	let fileValid = false;

	    選択されてるときだけチェック
	    if (fileField && fileField.files.length > 0) {
	        fileValid = validateFile(fileField);
	    }*/


	submitBtn.disabled = !(textValid && radioValid);
}


/* =========================
   イベント登録
========================= */

/* text / number */
textFields.forEach(field => {

	field.addEventListener("input", () => {
		validate(field);
		updateButton();
	});
});


/* radio */
radioFields.forEach(field => {

	field.addEventListener("change", () => {
		validateRadio(field.name);
		updateButton();
	});
});


/* file */
if (fileField) {
	fileField.addEventListener("change", () => {
		validateFile(fileField);
		updateButton();
	});
}

/* ダイアログ */
const form = document.querySelector("form");

const dialog = document.getElementById("myDialog");
const message = document.getElementById("dialogMessage");

const okBtu = document.getElementById("okBtu");
const noBtu = document.getElementById("noBtu");

if(form && dialog){
form.addEventListener("submit", function(e){
	e.preventDefault();
	
	message.textContent = "商品を登録しますか？"
	
	dialog.showModal();
});

noBtu.addEventListener("click", function(){
	dialog.close();
});

okBtu.addEventListener("click", function(){
	form.submit();
});

}
