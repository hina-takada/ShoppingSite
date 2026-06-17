package jp.co.aforce.servlet;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.HomeBean;
import jp.co.aforce.dao.HomeDAO;
import jp.co.aforce.tool.Action;

public class HomeSerchAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String keyword = request.getParameter("keyword");
		
		HomeDAO dao = new HomeDAO();
		List<HomeBean> products = (List<HomeBean>) dao.serch(keyword);
		
		if(products == null) return "home-product-error.jsp";
		
		session.setAttribute("keyword", keyword);
		session.setAttribute("products", products);
		
		return "serch-result.jsp";
	}

}
