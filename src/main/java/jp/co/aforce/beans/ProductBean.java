package jp.co.aforce.beans;

import java.time.LocalDateTime;

public class ProductBean implements java.io.Serializable{
	private int productId;//商品ID
	private String name;//商品名
	private int price;//価格
	private int count;//個数
	private int categoryId;//カテゴリーID
	private String categoryName;//カテゴリー名
	private String description;//説明文
	private String fileName;//
	private LocalDateTime registdate;//登録日
	private LocalDateTime updateDate;//更新日
	
	
	/**
	 * 商品ID
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
	 * カテゴリーID
	 * @return
	 */
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
	/**
	 * カテゴリー名
	 * 
	 * @return
	 */
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String string) {
		this.categoryName = string;
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
	
	/**
	 * 入力した月日
	 * 
	 * @return
	 */
	public LocalDateTime getRegistdate() {
		return registdate;
	}
	public void setRegistdate(LocalDateTime registdate) {
		this.registdate = registdate;
	}
	
	
	/**
	 * 更新時間
	 * 
	 * @return
	 */
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	
}
