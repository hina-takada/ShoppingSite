//ログイン用
const formId = document.getElementById("form-id");
const formPass = document.getElementById("form-pass");
const errorMsgId = document.getElementById("errorMsgId");
const errorMsgPass = document.getElementById("errorMsgPass");

const loginBtu = document.getElementById("login-btu");

function valideteInput(input, errorMsg, min, max) {
	const length = input.value.length;

	if (length < min || length > max) {
		errorMsg.style.display = "block";
		return false;
	}
	errorMsg.style.display = "none";
	return true;
}

function updateLoginBtton() {
	const maxId = 10;
	const minId = 4;
	const maxPass = 32;
	const minPass = 8;

	const isIdValid = valideteInput(formId, errorMsgId, minId, maxId);
	const isPassValid = valideteInput(formPass, errorMsgPass, minPass, maxPass);

	loginBtu.disabled = !(isIdValid && isPassValid);
}

formId.addEventListener("input", updateLoginBtton);
formPass.addEventListener("input", updateLoginBtton);


