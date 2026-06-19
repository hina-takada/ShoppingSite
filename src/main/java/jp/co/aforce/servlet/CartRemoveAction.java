package jp.co.aforce.servlet;

import java.util.Iterator;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.Item;
import jp.co.aforce.tool.Action;

@SuppressWarnings("unchecked")
public class CartRemoveAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		
		if(id == null || id.isBlank()) return "error";
		
		int listId = Integer.parseInt(id);
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		
		if(cart != null) {
			Iterator<Item> it = cart.iterator();
			
			while (it.hasNext()) {
				Item item =  it.next();
				
				if(item.getProduct().getProductId() == listId) {
					it.remove();
					break;
				}
			}
		}
		
		return "Cart.action";
	}
	
}
