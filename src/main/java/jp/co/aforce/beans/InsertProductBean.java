package jp.co.aforce.beans;

public class InsertProductBean implements java.io.Serializable{
	private String name;
	private int categoryId;
	private String categoryName;
	private int price;
	private int count;
	private String description;//説明文
	private String fileName;//画像パスの名前
	
	/**
	 * 商品名
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
	 * カテゴリーID
	 * 
	 * @return
	 */
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int category) {
		this.categoryId = category;
	}
	
	
	/**
	 * カテゴリー名
	 * @return
	 */
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	/**
	 * 価格
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
	 * 個数
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
	 * ファイル名
	 * 
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
