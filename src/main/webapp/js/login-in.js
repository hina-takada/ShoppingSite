//ログイン用

/*入力バリデーション*/
const formId = document.getElementById("form-id");
const formPass = document.getElementById("form-pass");
const errorMsgId = document.getElementById("errorMsgId");
const errorMsgPass = document.getElementById("errorMsgPass");

const loginBtu = document.getElementById("login-btu");

function valideteInput(input, errorMsg, min, max,regex) {
	const value = input.value;
	const length = value.length;
	
	//最初は
	if(length == 0){
		errorMsg.style.display = "none";
		return false;
	}
	
	if(!regex.test(value)){
			errorMsg.textContent = "半角英数または、先頭に記号は使用しないでください";
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

function updateLoginBtton() {
	const isIdValid = valideteInput(formId, errorMsgId, 4, 10, /^[a-zA-Z0-9]+$/);
	const isPassValid = valideteInput(formPass, errorMsgPass, 8, 32,/^[a-zA-Z0-9@#$%&]+$/);

	loginBtu.disabled = !(isIdValid && isPassValid);
}

formId.addEventListener("input", updateLoginBtton);
formPass.addEventListener("input", updateLoginBtton);
/*入力バリデーション*/

/*パスワード伏*/

const eye = document.getElementById("fa-eye");
const pass = document.getElementById("form-pass");

eye.addEventListener("click",() => {
	if(pass.type === "password"){
		pass.type = "text";
		eye.classList.remove("fa-eye");
		eye.classList.add("fa-eye-slash");
	}else{
		pass.type = "password";
		eye.classList.remove("fa-eye-slash");
		eye.classList.add("fa-eye");
	}
});


/*パスワード伏*/