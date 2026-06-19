package jp.co.aforce.beans;
/**
 * 情報修正用Been
 * 
 */
public class UpdateProductBeen implements java.io.Serializable{
	private int productId;
	private String name;//商品名
	private int price;//価格
	private int count;//個数
	private String description;//説明文
	private int categoryId;//カテゴリーID
	private String categoryName;//カテゴリー名
	private String fileName;//ファイル名
	
	
	/**
	 * 
	 * @return
	 */
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * 商品説明
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * 
	 * @return
	 */
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	/**
	 * 画像ファイル
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	

}
