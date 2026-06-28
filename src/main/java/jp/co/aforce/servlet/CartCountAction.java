package jp.co.aforce.servlet;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.Item;
import jp.co.aforce.tool.Action;

/**
 * カート数を増減させるサーブレット
 * 
 */
@SuppressWarnings("unchecked")
public class CartCountAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		String type = request.getParameter("type");

		String idS = request.getParameter("id");

		if (type == null || idS == null)
			return "error";

		int id = Integer.parseInt(idS);

		List<Item> items = (List<Item>) session.getAttribute("cart");

		if (items == null)
			return "error";

		for (Item item : items) {

			if (item.getProduct().getProductId() == id) {

				if ("plus".equals(type)) {

					// 現在数 + 1
					int newCount = item.getCount() + 1;

					// 在庫確認
					if (newCount > item.getProduct().getStock()) {

						request.setAttribute(
								"errorMessage",
								item.getProduct().getName()
										+ " の在庫が不足しています");

						return "error.jsp";

					}

					item.setCount(newCount);

				}

				if ("minus".equals(type)) {

					if (item.getCount() <= 1) {

						return "CartRemove.action?id=" + id;

					}

					item.setCount(item.getCount() - 1);

				}

				break;

			}

		}

		return "Cart.action";

	}

}