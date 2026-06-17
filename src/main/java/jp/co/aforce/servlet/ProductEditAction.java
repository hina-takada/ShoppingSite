package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UpdateProductBeen;
import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Action;

public class ProductEditAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		UpdateProductBeen upProduct = (UpdateProductBeen)session.getAttribute("upProduct");
		
		if(upProduct == null) return "product-edit-error.jsp";
		
		ProductDAO dao = new ProductDAO();
		boolean line = dao.update(upProduct.getProductId(),upProduct.getName(),upProduct.getCategoryId()
				,upProduct.getPrice(),upProduct.getCount(),upProduct.getDescription());
		
		if(line == false) return "product-edit-error.jsp";
		
		session.removeAttribute("upProduct");

		
		return "product-edit-success.jsp";
	}

}
