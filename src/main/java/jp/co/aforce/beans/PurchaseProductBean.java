package jp.co.aforce.beans;

import java.time.LocalDateTime;

public class PurchaseProductBean {
	private ProductBean product;
	private User user;
	private String orderId;
	private int subTotal;
	private int count;
	private int tax;
	private int totalTax;
	private int shippingFee;
	private int grandTotal;
	
	private LocalDateTime registdate;//登録日
	
	public PurchaseProductBean() {
		product = new ProductBean();
		user = new User();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public ProductBean getProduct() {
		return product;
	}
	public void setProduct(ProductBean product) {
		this.product = product;
	}
	
	/**
	 * 
	 * @return
	 */
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
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
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(int totalTax) {
		this.totalTax = totalTax;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(int shippingFee) {
		this.shippingFee = shippingFee;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
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
}
