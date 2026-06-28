package jp.co.aforce.beans;

/**
 * 情報修正用Bean
 * 
 */
public class UpdateProductBeen implements java.io.Serializable {

	private int productId;//商品ID
	private String name;//商品名
	private int price;//価格
	private int stock;//在庫数
	private int categoryId;//カテゴリーID
	private String categoryName;//カテゴリー名
	private int pawId;//肉球の感触
	private String pawName;//肉球の感触
	private String pawDescription;//肉球の感触 説明
	private String description;//説明文
	private String fileName;//画像のパス

	
	public int getProductId() {

		return productId;

	}

	public void setProductId(int productId) {

		this.productId = productId;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

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
	 * 肉球感触
	 */
	public int getPawId() {

		return pawId;

	}

	public void setPawId(int pawId) {

		this.pawId = pawId;

	}

	public String getPawName() {

		return pawName;

	}

	public void setPawName(String pawName) {

		this.pawName = pawName;

	}

	public String getPawDescription() {

		return pawDescription;

	}

	public void setPawDescription(String pawDescription) {

		this.pawDescription = pawDescription;

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

	public int getCategoryId() {

		return categoryId;

	}

	public void setCategoryId(int categoryId) {

		this.categoryId = categoryId;

	}

	public String getCategoryName() {

		return categoryName;

	}

	public void setCategoryName(String categoryName) {

		this.categoryName = categoryName;

	}

	/**
	 * 画像ファイル
	 */
	public String getFileName() {

		return fileName;

	}

	public void setFileName(String fileName) {

		this.fileName = fileName;

	}

}