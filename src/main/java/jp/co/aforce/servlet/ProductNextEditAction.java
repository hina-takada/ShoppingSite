package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UpdateProductBeen;
import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Action;


public class ProductNextEditAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("productId");
		String mode = request.getParameter("model");
		
		if(id == null || mode == null)return "product-menu.jsp";
		
		int productId = Integer.parseInt(id);
		
		ProductDAO dao = new ProductDAO();
		UpdateProductBeen upProduct = dao.updateSerch(productId);
		
		session.setAttribute("upProduct",upProduct);
		
		if("delete".equals(mode)) return "product-delete.jsp";
		
		return "product-edit.jsp";
	}

}
