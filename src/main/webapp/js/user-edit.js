/* =========================
   要素取得
========================= */
const inputs = document.querySelectorAll("input[name]");
const vailBtu = document.getElementById("vail-btu");

/* =========================
   ルール
========================= */
const rules = {
	lastName: { min: 1, max: 32, regex: /^[ぁ-んァ-ヶ一-龠々A-Za-z]+$/, message: "使用できない文字が含まれています" },
	firstName: { min: 1, max: 32, regex: /^[ぁ-んァ-ヶ一-龠々A-Za-z]+$/, message: "使用できない文字が含まれています" },
	address: { min: 1, max: 128, regex: /^[^<>]+$/, message: "使用できない文字が含まれています" },
	mailAddress: { min: 1, max: 128, regex: /^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/, message: "メール形式が正しくありません" }
};

/* ======================
   エラー
========================= */
function showError(input, select, msg) {
	const el = input.parentElement.querySelector(select);
	el.textContent = msg;
	el.classList.remove("is-hidden");
}

function hideError(input, select) {
	const el = input.parentElement.querySelector(select);
	el.textContent = "";
	el.classList.add("is-hidden");
}

/* =========================
   通常バリデーション
========================= */
function validate(input) {
	const rule = rules[input.name];
	const value = input.value;
	const min = rule.min;
	const max = rule.max;

	if (value.length < min || value.length > max) {
		showError(input, ".error", `${min}～${max}字以内で入力してください`);
		return false;
	}

	if (!rule.regex.test(value)) {
		showError(input, ".error", rule.message);
		return false;
	}

	hideError(input, ".error");
	return true;
}

/* =========================
   ボタン制御(入力されたものが正しいか)
========================= */
function  isFormValid(input){
	const rule = rules[input.name];
	const value = input.value;
	
	return (
		value.length >= rule.min &&
		value.length <= rule.max &&
		rule.regex.test(value)
	);
		
}

/* =========================
   ボタン制御
========================= */
function updateBut(){	
	vailBtu.disabled = !([...inputs].every(input => isFormValid(input)));
}

/*==================
  input処理
==================*/
inputs.forEach(input => {
	input.addEventListener("input", () => {
		validate(input);
		updateBut();
	});
});
