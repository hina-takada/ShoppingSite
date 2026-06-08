
/* =========================
   要素取得
========================= */
const inputs = document.querySelectorAll("input[name]");
const idInput = document.querySelector("input[name='id']");
const valiBtu = document.getElementById("vali-btu");

/* =========================
   状態
========================= */
const state = {
	filed: {
		id: false,
		pass: false,
		lastName: false,
		firstName: false,
		address: false,
		mailAddress: false
	},
	id: {
		format: false,
		server: false
	}
};

/* =========================
   ルール
========================= */
const rules = {
	id: { min: 4, max: 10, regex: /^[a-zA-Z0-9]+$/, message: "英数字のみ使用できます" },
	pass: { min: 8, max: 32, regex: /^[a-zA-Z0-9@#$%&]+$/, message: "使用できない文字が含まれています" },
	lastName: { min: 1, max: 32, regex: /^[ぁ-んァ-ヶ一-龠々A-Za-z]+$/, message: "使用できない文字が含まれています" },
	firstName: { min: 1, max: 32, regex: /^[ぁ-んァ-ヶ一-龠々A-Za-z]+$/, message: "使用できない文字が含まれています" },
	address: { min: 1, max: 128, regex: /^[^<>]+$/, message: "使用できない文字が含まれています" },
	mailAddress: { min: 1, max: 128, regex: /^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/, message: "メール形式が正しくありません" }
};

/* ====================
   エラー
======================= */
function showError(input, selector, msg) {
	const el = input.parentElement.querySelector(selector);
	el.textContent = msg;
	el.classList.remove("is-hidden");
}

function hideError(input, selector) {
	const el = input.parentElement.querySelector(selector);
	el.textContent = "";
	el.classList.add("is-hidden");
}

/* =========================
   通常バリデーション
========================= */
function validate(input) {
	const rule = rules[input.name];
	const value = input.value;

	if (!rule) return true;

	if (value.length === 0) {
		state.filed[input.name] = false;
		hideError(input, ".error-length");
		return false;
	}

	if (value.length < rule.min || value.length > rule.max) {
		state.filed[input.name] = false;
		showError(input, ".error-length", `${rule.min}〜${rule.max}文字で入力してください`);
		return false;
	}

	if (!rule.regex.test(value)) {
		state.filed[input.name] = false;
		showError(input, ".error-length", rule.message);
		return false;
	}

	state.filed[input.name] = true;
	hideError(input, ".error-length");
	return true;
}

/* =========================
   IDフォーマット
========================= */
function isValidIdFormat(value) {
	const r = rules.id;
	return (
		value.length >= r.min &&
		value.length <= r.max &&
		r.regex.test(value)
	);
}

/* =========================
   サーバー重複チェック
========================= */
let lastRequestId = 0;

function checkIdServer(value) {
	const requestId = ++lastRequestId;

	return fetch("../checkid?id=" + encodeURIComponent(value))
		.then(res => {
			if (!res.ok) throw new Error("server error");
			return res.json();
		})
		.then(data => {
			if (requestId !== lastRequestId) return null;
			return data;
		})
		.catch(() => null);
}

/* =========================
   ボタン制御
========================= */
function updateButton() {
	const hasError =
		Object.values(state.filed).includes(false) ||
		!state.id.format ||
		!state.id.server;

	valiBtu.disabled = hasError;
}

/* =========================
   通常input（ID以外）
========================= */
inputs.forEach(input => {
	if (input.name === "id") return;

	input.addEventListener("input", () => {
		validate(input);
		updateButton();
	});
});

/* =========================
   ID処理
========================= */
let timer;

idInput.addEventListener("input", () => {
	const value = idInput.value;

	clearTimeout(timer);

	timer = setTimeout(async () => {

		/* ① formatチェック */
		const formatOK = isValidIdFormat(value);
		state.id.format = formatOK;
		state.filed.id = formatOK;

		if (!formatOK) {
			state.id.server = false;
			showError(idInput, ".error-id", "4〜10文字の英数字で入力してください");
			updateButton();
			return;
		}

		hideError(idInput, ".error-id");

		/* ② サーバーチェック */
		const data = await checkIdServer(value);

		if (!data) return;

		state.id.server = !data.exists;
		state.filed.id = state.id.server;

		if (data.exists) {
			showError(idInput, ".error-id", "このIDは既に使われています");
		} else {
			hideError(idInput, ".error-id");
		}

		updateButton();

	}, 500);
});

/* =========================
   戻る対応（重要）
========================= */
window.addEventListener("load", async () => {

	// 他input再チェック
	inputs.forEach(input => {
		if (input.name !== "id") {
			validate(input);
		}
	});

	// ID復元チェック
	const value = idInput.value;

	if (!value) {
		updateButton();
		return;
	}

	const formatOK = isValidIdFormat(value);
	state.id.format = formatOK;
	state.filed.id = formatOK;

	if (!formatOK) {
		updateButton();
		return;
	}

	const data = await checkIdServer(value);

	if (!data) return;

	state.id.server = !data.exists;
	state.filed.id = state.id.server;

	if (data.exists) {
		showError(idInput, ".error-id", "このIDは既に使われています");
	}

	updateButton();
});