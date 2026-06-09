package jp.co.aforce.beans;

import java.time.LocalDateTime;

public class ProductBean {
	private int productId;
	private String name;
	private int price;
	private int count;
	private LocalDateTime registdate;
	private LocalDateTime updateDate;
	
	
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
