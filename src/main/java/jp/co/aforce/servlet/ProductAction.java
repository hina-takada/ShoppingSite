package jp.co.aforce.servlet;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Action;

public class ProductAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		int page = 1;
		String pageStr = (String) request.getParameter("page");
		if(pageStr != null) page = Integer.parseInt(pageStr);
		
		int limit = 10;//表示するページ数
		int offset = (page - 1) * limit;
		
		ProductDAO dao = new ProductDAO();
		
		int totalCount = dao.countAll();
		int totalPages = (int)Math.ceil((double)totalCount / limit);
		
		List<ProductBean> products = dao.serchManerger(limit,offset);
		
		if(products == null) return "product-error.jsp";
		
		session.setAttribute("products", products);
		session.setAttribute("currentPage", page);
		session.setAttribute("totalPages", totalPages);
		
		return "product-menu.jsp";
	}

}
