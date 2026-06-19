package jp.co.aforce.beans;

public class InsertUserBean implements java.io.Serializable{
	
	private String id;//会員番号
	private String pass;
	private String lastName;//名前_姓
	private String firstName;//名前_名
	private String address;//住所
	private String mailAddress;//メースアドレス
	
	/**
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
	
}
