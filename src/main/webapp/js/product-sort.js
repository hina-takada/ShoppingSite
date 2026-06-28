function autoSubmit() {


	sessionStorage.setItem(
		"scrollPosition",
		window.scrollY
	);


	sessionStorage.setItem(
		"categoryOpen",
		document.getElementById("category").classList.contains("open")
	);


	sessionStorage.setItem(
		"pawOpen",
		document.getElementById("paw-types").classList.contains("open")
	);


	document.getElementById("filterForm").submit();

}





function sortSubmit(sortValue) {


	const form = document.getElementById("filterForm");


	let input = form.querySelector("input[name='sort']");


	if(!input){

		input = document.createElement("input");

		input.type = "hidden";

		input.name = "sort";

		form.appendChild(input);

	}


	input.value = sortValue;


	form.submit();

}





document.addEventListener("DOMContentLoaded", function(){



	// スクロール位置復元



	if(scroll){

		window.scrollTo(
			0,
			Number(scroll)
		);

	}




	// カテゴリー状態復元

	const category = document.getElementById("category");


	if(
		sessionStorage.getItem("categoryOpen") === "true"
	){

		category.classList.add("open");

	}




	// 肉球状態復元

	const pawTypes = document.getElementById("paw-types");


	if(
		sessionStorage.getItem("pawOpen") === "true"
	){

		pawTypes.classList.add("open");

	}







	// 並び替え

	const sortBtn = document.getElementById("sortBtu");

	const sortMenu = document.getElementById("sortMenu");


	if(sortBtn && sortMenu){


		sortBtn.addEventListener("click",function(){


			sortMenu.classList.toggle("show");


		});


	}







	// 動物開閉

	const categoryTitle = document.getElementById("categoryTitle");


	categoryTitle.addEventListener("click",function(){


		category.classList.toggle("open");


		sessionStorage.setItem(
			"categoryOpen",
			category.classList.contains("open")
		);


	});



	// 肉球開閉

	const pawTitle = document.getElementById("pawTitle");


	pawTitle.addEventListener("click",function(){


		pawTypes.classList.toggle("open");


		sessionStorage.setItem(
			"pawOpen",
			pawTypes.classList.contains("open")
		);


	});



});