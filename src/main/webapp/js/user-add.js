
/* 入力フォームのチェック */
const idInput = document.querySelector("input[name='id']");
const inputs = document.querySelectorAll("input[name]");
const valiBtu = document.getElementById("vali-btu"); 

const rules = {
	id: { min: 4, max: 10 },
	pass: { min: 8, max: 32 },
	lastName: { min: 1, max: 32 },
	firstName: { min: 1, max: 32 },
	address: { min: 1, max: 128 },
	mailAddress: { min: 1, max: 128 }
};

function showError(input, message) {
	const error = input.parentElement.querySelector(".error");
	error.textContent = message;
	error.classList.remove("is-hidden");
}

function hideError(input) {
	const error = input.parentElement.querySelector(".error");
	error.textContent = "";
	error.classList.add("is-hidden");
}

inputs.forEach((input) => {
	/* */
	input.addEventListener("input", () => {
		const value = input.value;
		const length = value.length;

		if (length === 0) {
			hideError(input);
			return;
		}

		const name = input.name;
		const rule = rules[name];

		if (!rule) return;

		const min = rule.min;
		const max = rule.max;

		if (length < min || length > max) {
			showError(input, `${min}～${max}文字以内で書いてください`);
		} else {
			hideError(input);
		}
	});
});
/* 入力フォームのチェック */

/* 同じIDはあるか*/
idInput.addEventListener("blur", () => {
	const id = idInput.value;

	if (!id) return;

	fetch("../checkid?id=" + id)
		.then(res => res.json())
		.then(data => {
			if (data.exists) {
				showError(idInput, "このIDは使われています");
			} else {
				hideError(idInput);
			}
		});
});
/* 同じIDであるか */

valiBtu.addEventListener("");

