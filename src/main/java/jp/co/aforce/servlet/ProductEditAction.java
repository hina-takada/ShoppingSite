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
public class ProductEditAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		String productIdS = request.getParameter("productId");
		String name = request.getParameter("name");
		String categoryIdS = request.getParameter("categoryId");
		String priceS = request.getParameter("price");
		String countS = request.getParameter("count");
		String description = request.getParameter("description");

		//バリデーション
		String url = validation(productIdS,name, categoryIdS, priceS, countS, description);
		if (url.equals("product-error.jsp"))
			return url;

		//name属性がpictのファイルをPartオブジェクトとして取得
		Part part = request.getPart("img");
		//ファイル名を取得する変数
		String filename;

		if (part.getSubmittedFileName() != null
				&& !part.getSubmittedFileName().isBlank()) {

			String oldFileName = request.getParameter("oldFileName");

			//name属性がpictのファイルをPartオブジェクトとして取得
			part = request.getPart("img");
			//ファイル名を取得
			filename = Paths.get(part.getSubmittedFileName())
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

			//古いファイル削除
			File oldFile = new File(path, oldFileName);
			if (oldFile.exists()) {
				oldFile.delete();
			}

		} else {
			filename = request.getParameter("oldFileName");
		}

		//数字に変換
		int price = Integer.parseInt(priceS);
		int productId = Integer.parseInt(productIdS);
		int count = Integer.parseInt(countS);
		int categoryId = Integer.parseInt(categoryIdS);

		ProductDAO dao = new ProductDAO();
		boolean line = dao.update(productId,name, categoryId, price, count, description,filename);

		if (line == false)
			return "product-edit-error.jsp";

		session.removeAttribute("upProduct");

		return "product-edit-success.jsp";
	}

	//入力バリデーション
	private String validation(String productId,String name, String category, String price, String count, String description)
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
		 * 
		 */
		if (productId == null || productId.isEmpty()) {
			System.out.println("productIdエラー");
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
		 * 
		 * 
		 */
		if (description == null || description.isBlank() || description.isEmpty() || description.length() > 200) {
			System.out.println("nameエラー");
			return url;
		}

		url = "ProductEdit.action";
		return url;

	}

}
