package jp.co.aforce.servlet;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.beans.User;
import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Action;

public class ProductAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		//仮置き認証
		if(session == null || !"ADMIN".equals(user.getRole())) {
			return "product-error.jsp";
		}
		
		ProductDAO dao = new ProductDAO();
		List<ProductBean> products = dao.serch();
		
		if(products == null) return "product-error.jsp";
		
		session.setAttribute("products", products);
		
		return "product-menu.jsp";
	}

}
