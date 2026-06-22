
function autoSubmit() {
	document.getElementById("filterForm").submit();

}

//並び替え用
function sortSubmit(sortValue) {
	const form = document.getElementById("filterForm");


	//既存のsortを削除
	let input = form.querySelector("input[name='sort']");

	if (input) {
		document.createElement("input");
		input.type = "hidden";
		input.name = "sort";
		form.appendChild(input);
	}

	input.value = sortValue;

	form.submit();
}


