package jp.co.aforce.servlet;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Action;

public class HomeSerchAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String keyword = request.getParameter("keyword");
		
		ProductDAO dao = new ProductDAO();
		List<ProductBean> products = (List<ProductBean>) dao.serch(keyword);
		
		if(products == null) return "home-product-error.jsp";
		
		request.setAttribute("keyword", keyword);
		session.setAttribute("products", products);
		
		return "serch-result.jsp";
	}

}
