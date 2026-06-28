package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Action;

@SuppressWarnings("unused")
public class ProductDetailAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String idS = request.getParameter("id");
		boolean vali = validation(idS);
		if(!vali) return "product-detail-error.jsp";
		
		 int id = Integer.parseInt(idS);
		 ProductDAO dao = new ProductDAO();
		 ProductBean product = dao.productSerch(id);
		 
		 if(product == null)return "product-detail-error.jsp";

		 session.setAttribute("product", product);
		return "product-detail.jsp";
	}
	
	//バリデーション
	private boolean validation(String productId)
			throws Exception {
		/**
		 * IDのバリデーション
		 */
		if (productId == null || productId.isEmpty()) {
			System.out.println("productIdエラー");
			return false;
		}

		return true;
	}

}
