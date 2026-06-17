package jp.co.aforce.servlet;

import java.io.File;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Action;

@MultipartConfig
public class ProductAddAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		String name = request.getParameter("name");
		String categoryIdS = request.getParameter("categoryId");
		String priceS = request.getParameter("price");
		String countS = request.getParameter("count");
		String description = request.getParameter("description");

		//バリデーション
		String url = validation(name, categoryIdS, priceS, countS, description);
		if (url.equals("prouduct-error.jsp"))
			return url;

		//name属性がpictのファイルをPartオブジェクトとして取得
		Part part = request.getPart("img");
		//ファイル名を取得
		String filename = part.getSubmittedFileName();
		//アップロードするフォルダ
		String path = request.getServletContext().getRealPath("/upload");
		/*		//実際にファイルが保存されるパス確認
		
				System.out.println(path);*/
		//書き込み
		part.write(path + File.separator + filename);
		
		File file = new File(path + File.separator + filename);

		System.out.println(file.getAbsolutePath());
		System.out.println(file.exists());
		
		//数字に変換
		int price = Integer.parseInt(priceS);
		int count = Integer.parseInt(countS);
		int categoryId = Integer.parseInt(categoryIdS);

		ProductDAO dao = new ProductDAO();
		boolean line = dao.insert(name, price, count, categoryId, description,filename);

		if (line == false)
			return "product-error.jsp";

		return "product-add-success.jsp";
	}

	
	//入力バリデーション
	private String validation(String name, String category, String price, String count, String description)
			throws Exception {
		String url = "product-error.jsp";

		/**
		 * 商品名
		 */
		if (name == null || name.isBlank() || name.isEmpty() || name.length() > 100
				|| !name.matches("^[ぁ-んァ-ヶー一-龠々A-Za-z]+$")) {
			System.out.println("nameエラー");
			return url;
		}

		/**
		 * カテゴリー
		 */
		if (category == null || category.isEmpty()) {
			System.out.println("categoryエラー");
			return url;
		}

		int numCate = Integer.parseInt(category);
		if (numCate < 1 || numCate > 3) {
			System.out.println("categoryNameエラー");
			return url;
		}
		/**
		 * 価格
		 */
		if (price == null || price.isEmpty()) {
			System.out.println("priceエラー");
			return url;
		}

		int numPri = Integer.parseInt(price);
		if (numPri < 0 || numPri > 99999) {
			System.out.println("price範囲エラー");
			return url;
		}

		/**
		 * 個数
		 */
		if (count == null || count.isEmpty()) {
			System.out.println("countエラー");
			return url;
		}

		int numCou = Integer.parseInt(count);
		if (numCou < 0 || numCou > 9999) {
			System.out.println("count範囲エラー");
			return url;
		}

		/**
		 * 説明文
		 * 
		 */
		if (description == null || description.isBlank() || description.isEmpty() || description.length() > 200) {
			System.out.println("nameエラー");
			return url;
		}

		url = "admin-edit-success.jap";
		return url;

	}
}
