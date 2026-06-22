package jp.co.aforce.servlet;

import java.util.List;
import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.Item;
import jp.co.aforce.beans.User;
import jp.co.aforce.dao.PurchaseDAO;
import jp.co.aforce.tool.Action;
/***
 * 購入処理
 * 
 */
@SuppressWarnings("unchecked")
public class PurchasesAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		String lastName = request.getParameter("last-name");
		String firstName = request.getParameter("first-name");
		String address = request.getParameter("address");
		
		boolean isVali = validation(lastName,firstName, address);
		if (!isVali)
			return "error.jsp";
		
		int tax = (int)session.getAttribute("tax");
		int SHIPPING_FEE = (int)session.getAttribute("SHIPPING_FEE");
		int totalTax =(int)session.getAttribute("totalTax");		
		int grandTotal =(int)session.getAttribute("grandTotal");
		
		//ちゅうもんID 
		String orderId = UUID.randomUUID().toString();
		
		User user = (User) session.getAttribute("user");
		String userid =user.getId();

		PurchaseDAO dao = new PurchaseDAO();
		List<Item> items = (List<Item>)session.getAttribute("cart");
		if(items == null ||  !dao.insert(items,tax,totalTax,SHIPPING_FEE,grandTotal,userid, lastName, firstName, address,orderId))
			return "puchase-error-insert";
		
		session.removeAttribute("items");
		session.removeAttribute("tax");
		session.removeAttribute("SHIPPING_FEE");
		session.removeAttribute("totalTax");		
		session.removeAttribute("grandTotal");
		session.removeAttribute("cart");
		session.setAttribute("orderId",orderId);
		
		return "PurchaseProduct.action";
	}

	private boolean validation(String lastName,String firstName, String address) {

		if (lastName.isEmpty() || lastName.isBlank() || lastName.length() > 100 || !lastName.matches("^[ぁ-んァ-ヶ一-龠々A-Za-z]+$"))
			return false;
		
		if (firstName.isEmpty() || firstName.isBlank() || firstName.length() > 100 || !firstName.matches("^[ぁ-んァ-ヶ一-龠々A-Za-z]+$"))
			return false;

		if (address.isEmpty() || address.isBlank() || address.length() > 128 || !address.matches("^[^<>]+$"))
			return false;

		return true;
	}

}
