package jp.co.aforce.servlet;

import java.io.File;
import java.nio.file.Paths;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.Const;

@MultipartConfig
public class ProductAddAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		String name = request.getParameter("name");
		String categoryIdS = request.getParameter("categoryId");
		String pawIdS = request.getParameter("pawId");
		String priceS = request.getParameter("price");
		String stockS = request.getParameter("stock");
		String description = request.getParameter("description");

		//バリデーション
		String url = validation(name, categoryIdS,pawIdS, priceS, stockS, description);
		if (url.equals("prouduct-add-error.jsp"))
			return url;

		//name属性がpictのファイルをPartオブジェクトとして取得
		Part part = request.getPart("img");
		//ファイル名を取得
		String filename = Paths.get(part.getSubmittedFileName())
				.getFileName()
				.toString();

		//アップロードするフォルダ
		/**
		 * ★AWSの際は、ここを変更する。
		 * "/home/ec2-user/upload"
		 * 
		 * EC2:
		 * コマンド（sshでログイン）
		mkdir /home/ec2-user/upload
		chmod 777 /home/ec2-user/upload
		
		 */
		String path = Const.UPLOAD_PATH;

		File dir = new File(path);

		if (!dir.exists()) {
			dir.mkdirs();
		}

		//書き込み
		File file = new File(dir, filename);
		part.write(file.getAbsolutePath());

		//数字に変換
		int price = Integer.parseInt(priceS);
		int stock = Integer.parseInt(stockS);
		int categoryId = Integer.parseInt(categoryIdS);
		int pawId = Integer.parseInt(pawIdS);

		ProductDAO dao = new ProductDAO();
		boolean line = dao.insert(name, price, stock, categoryId, description, filename,pawId);

		if (line == false)
			return "product-add-error.jsp";

		return "product-add-success.jsp";
	}

	//入力バリデーション
	private String validation(String name, String category,String pawId, String price, String stock, String description)
			throws Exception {
		String url = "product-add-error.jsp";

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
		if (numCate < 1 || numCate > 4) {
			System.out.println("categoryNameエラー");
			return url;
		}
		
		/**
		 * 肉球
		 */
		if (pawId == null || pawId.isEmpty()) {
			System.out.println("pawIdエラー");
			return url;
		}

		int pawnum = Integer.parseInt(pawId);
		if (pawnum < 1 || pawnum > 4) {
			System.out.println("pawIdエラー");
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
		if (stock == null || stock.isEmpty()) {
			System.out.println("stockエラー");
			return url;
		}

		int numStock = Integer.parseInt(stock);

		if (numStock < 0 || numStock > 9999) {
			System.out.println("stock範囲エラー");
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

		url = "admin-add-success.jsp";
		return url;

	}
}
