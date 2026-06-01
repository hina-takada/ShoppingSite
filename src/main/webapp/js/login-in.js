
const formId = document.getElementById("form-id");
const formPass = document.getElementById("form-pass");
const errorMsgId = document.getElementById("errorMsgId");
const errorMsgPass = document.getElementById("errorMsgPass");

const loginBtu = document.getElementById("login-btu");

formId.addEventListener("input", () => {
	const maxId = 10;
	const minId = 4;
	const idLength = formId.value.length;

	if (idLength < minId || idLength > maxId) {
		errorMsgId.style.display = "block";
		loginBtu.disabled = false;
	} else {
		errorMsgId.style.display = "none";
		loginBtu.disabled = true;
	}

});

formPass.addEventListener("input", () => {
	const maxPass = 32;
	const minPass = 5;

	const passLength = formPass.value.length;

	if (passLength < minPass || passLength > maxPass) {
		errorMsgPass.style.display = "block";
		loginBtu.disabled = false;
	} else {
		errorMsgPass.style.display = "none";
		loginBtu.disabled = true;
	}
});


