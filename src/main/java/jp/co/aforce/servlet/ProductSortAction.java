package jp.co.aforce.servlet;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.ProductSortDAO;
import jp.co.aforce.tool.Action;

public class ProductSortAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);

		String sort = request.getParameter("sort");
		String[] categorys = request.getParameterValues("category");
		String[] paws = request.getParameterValues("paws");

		ProductSortDAO dao = new ProductSortDAO();
		List<ProductBean> productList = dao.serch(categorys,paws, sort);

		session.setAttribute("products", productList);

		return "home.jsp";
	}

}
