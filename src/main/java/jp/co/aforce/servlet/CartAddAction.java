package jp.co.aforce.servlet;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.Item;
import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Action;

@SuppressWarnings("unchecked")
public class CartAddAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();


		String idS = request.getParameter("id");
		String countS = request.getParameter("count");


		if (idS == null || countS == null) {
			return "error.jsp";
		}


		int id = Integer.parseInt(idS);
		int count = Integer.parseInt(countS);


		if (count <= 0) {
			return "error.jsp";
		}


		// DBから最新の商品情報取得
		ProductDAO dao = new ProductDAO();

		ProductBean product = dao.productSerch(id);


		if (product == null) {
			return "error.jsp";
		}


		// カート取得
		List<Item> cart =
				(List<Item>) session.getAttribute("cart");


		if (cart == null) {

			cart = new ArrayList<>();

			session.setAttribute("cart", cart);
		}



		// すでにカートにある商品
		for (Item item : cart) {


			if (item.getProduct().getProductId() == id) {


				int totalCount = item.getCount() + count;


				// 在庫確認
				if (totalCount > product.getStock()) {


					request.setAttribute(
						"errorMessage",
						product.getName() + " の在庫が不足しています"
					);


					return "error.jsp";
				}


				item.setCount(totalCount);


				return "Cart.action";
			}
		}



		// 初回追加
		if (count > product.getStock()) {


			request.setAttribute(
				"errorMessage",
				product.getName() + " の在庫が不足しています"
			);


			return "error.jsp";
		}



		Item item = new Item();

		item.setProduct(product);

		item.setCount(count);


		cart.add(item);



		session.removeAttribute("keyword");


		return "Cart.action";
	}

}