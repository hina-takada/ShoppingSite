package jp.co.aforce.beans;

public class InsertProductBean implements java.io.Serializable {

	private String name;
	private int categoryId;
	private String categoryName;
	private int price;
	private int stock;
	private String description;//説明文
	private String fileName;//画像パスの名前

	/**
	 * 商品名
	 */
	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	/**
	 * カテゴリーID
	 */
	public int getCategoryId() {

		return categoryId;

	}

	public void setCategoryId(int categoryId) {

		this.categoryId = categoryId;

	}

	/**
	 * カテゴリー名
	 */
	public String getCategoryName() {

		return categoryName;

	}

	public void setCategoryName(String categoryName) {

		this.categoryName = categoryName;

	}

	/**
	 * 価格
	 */
	public int getPrice() {

		return price;

	}

	public void setPrice(int price) {

		this.price = price;

	}

	/**
	 * 在庫数
	 */
	public int getStock() {

		return stock;

	}

	public void setStock(int stock) {

		this.stock = stock;

	}

	/**
	 * 商品説明
	 */
	public String getDescription() {

		return description;

	}

	public void setDescription(String description) {

		this.description = description;

	}

	/**
	 * ファイル名
	 */
	public String getFileName() {

		return fileName;

	}

	public void setFileName(String fileName) {

		this.fileName = fileName;

	}

}