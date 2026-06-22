package jp.co.aforce.servlet;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.Item;
import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.tool.Action;

@SuppressWarnings("unchecked")
public class CartAddAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		String idS = request.getParameter("id");
		String countS = request.getParameter("count");
		
		//Stringバリ
		if(idS == null || countS == null)return "error";
		
		int id = Integer.parseInt(idS);
		int count = Integer.parseInt(countS);
		
		//intバリ
		if(count <= 0)return "error";

		List<Item> cart = (List<Item>) session.getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<Item>();
			session.setAttribute("cart", cart);
		}
		
		for (Item item : cart) {
			if (item.getProduct().getProductId() == id) {
				item.setCount(item.getCount() + count);
				return "Cart.action";
			}
		}

		
		ProductBean product = (ProductBean) session.getAttribute("product");
		
		if(product == null)return "error";
		
		Item i = new Item();
		i.setProduct(product);
		i.setCount(count);
		cart.add(i);
		
	
		session.removeAttribute("keyword");
		
		return "Cart.action";
	}

}
