package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UpdateProductBeen;
import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Action;

public class ProductDeleteAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		ProductDAO dao = new ProductDAO();
		
		UpdateProductBeen upProduct = (UpdateProductBeen)session.getAttribute("upProduct");
		String id = Integer.toString(upProduct.getProductId());
		
		if(upProduct == null || id == null || id.isBlank()) {
			return "product-error.jsp";
		}
		
		boolean line = dao.delete(upProduct.getProductId());
		
		if(line == false)return "product-error.jsp";
		
		
		session.removeAttribute("upProduct");
		
		return "product-delete-success.jsp";
	}

}
