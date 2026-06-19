package jp.co.aforce.servlet;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.Item;
import jp.co.aforce.tool.Action;
/**
 * カート/購入 
 * 
 */

@SuppressWarnings("unchecked")
public class CartAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		List<Item> items = (List<Item>) session.getAttribute("cart");
		
		if(items == null)return "error";
		
		/*税抜合計*/
		int total = 0;
		for(Item item : items) {
			int subtotal = item.getProduct().getPrice() 
					* item.getCount();
			
			item.setSubTotal(subtotal);
			
			total += subtotal;
		}
		
		/*税込み*/
		int tax = (int)(total * 0.1);
		int totalTax = total + tax;
		
		/*送料含み*/
		final int SHIPPING_FEE = 800;
		int grandTotal = totalTax + SHIPPING_FEE;

		session.setAttribute("tax",tax);
		session.setAttribute("SHIPPING_FEE",SHIPPING_FEE);
		session.setAttribute("totalTax",totalTax);		
		session.setAttribute("grandTotal",grandTotal);		
		
		return "cart.jsp";
	}

}
