package jp.co.aforce.beans;

public class Item implements java.io.Serializable{
	private ProductBean product;
	private int count;
	private int subTotal;//小計
	
	
	public ProductBean getProduct() {
		return product;
	}
	public void setProduct(ProductBean product) {
		this.product = product;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	public int getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}
	
}
