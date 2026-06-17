package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UpdateProductBeen;
import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Action;

public class ProductEditValidationAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		
		String name = request.getParameter("name");
		String categoryId = request.getParameter("categoryId");
		String price = request.getParameter("price");
		String count = request.getParameter("count");
		String description = request.getParameter("description");
		
		String url = validation(name, categoryId, price, count,description);
		if(url.equals("product-error.jsp"))return url;
		
		
		//確認用のカテゴリー名
		ProductDAO dao = new ProductDAO();
		String categoryName = dao.getCategoryName(Integer.parseInt(categoryId));
		
		UpdateProductBeen upProduct = (UpdateProductBeen)session.getAttribute("upProduct");
		upProduct.setName(name);
		upProduct.setCategoryId(Integer.parseInt(categoryId));
		upProduct.setCategoryName(categoryName);
		upProduct.setPrice(Integer.parseInt(price));
		upProduct.setCount(Integer.parseInt(count));
		upProduct.setDescription(description);
		
		session.setAttribute("upProduct", upProduct);
		return url;
	}
	
	
	//入力バリデーション
		private String validation(String name,String category,String price,String count,String description) throws Exception {
			String url = "product-error.jsp";
			
			/**
			 * 商品名
			 */
			if (name == null || name.isBlank() || name.isEmpty()|| name.length() > 100 || !name.matches("^[ぁ-んァ-ヶー一-龠々A-Za-z]+$") ){
				System.out.println("nameエラー");
				return url;
			}

			/**
			 * カテゴリー
			 */
			if (category == null || category.isEmpty()){
				System.out.println("categoryエラー");
				return url;
			}
			
			int numCate = Integer.parseInt(category);
			if(numCate < 1 || numCate > 3) {
				System.out.println("categoryNameエラー");
				return url;
			}
			/**
			 * 価格
			 */
			if (price == null || price.isEmpty()){
				System.out.println("priceエラー");
				return url;
			}
			
			int numPri = Integer.parseInt(price);
			if(numPri < 0 || numPri > 99999) {
				System.out.println("price範囲エラー");
				return url;
			}
			
			/**
			 * 個数
			 */
			if (count == null || count.isEmpty()){
				System.out.println("countエラー");
				return url;
			}
			
			int numCou = Integer.parseInt(count);
			if(numCou < 0 || numCou > 9999) {
				System.out.println("count範囲エラー");
				return url;
			}
			
			/**
			 * 
			 * 
			 */
			if (description == null || description.isBlank() || description.isEmpty()|| description.length() > 200 ){
				System.out.println("nameエラー");
				return url;
			}
			
			url = "product-edit-validation.jsp";
			return url;
			
			
		}
}
