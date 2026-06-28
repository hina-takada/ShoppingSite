package jp.co.aforce.servlet;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Action;

public class HomeProductAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		String form = request.getParameter("form");
		
		
		ProductDAO dao = new ProductDAO();
		List<ProductBean> products = dao.serch();
		
		if(products == null) return "home-error.jsp";
		
		session.setAttribute("products", products);
		
		return "home.jsp";
	}

}
