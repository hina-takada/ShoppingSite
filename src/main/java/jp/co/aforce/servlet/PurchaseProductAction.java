package jp.co.aforce.servlet;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.PurchaseProductBean;
import jp.co.aforce.dao.PurchaseDAO;
import jp.co.aforce.tool.Action;

public class PurchaseProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String orderId = (String) session.getAttribute("orderId");

		PurchaseDAO dao = new PurchaseDAO();
		List<PurchaseProductBean> purchases = dao.serch(orderId);
		
		session.setAttribute("purchases", purchases);
		session.removeAttribute("orderId");
		return "purchase-out.jsp";
	}

}
