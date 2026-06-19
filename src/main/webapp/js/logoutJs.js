//DOMConten..:Webページ(画像などのリソースは含まれない)の読み込み完了で出力
//画面を含む場合は,loadを使用
window.addEventListener("load", function() {
	const dialog = document.getElementById("myDialog");
	const message = document.getElementById("dialogMessage");
	const logout = document.getElementById("logout");
	const okBtu = document.getElementById("okBtu");
	const noBtu = document.getElementById("noBtu");

	logout.addEventListener("click", function() {
		message.textContent = "ログアウトしますか？";
		dialog.showModal();

	});

	noBtu.addEventListener("click", function() {
		dialog.close();
	});

	okBtu.addEventListener("click", function() {
		window.location.href = "Logout.action";
	});

});

