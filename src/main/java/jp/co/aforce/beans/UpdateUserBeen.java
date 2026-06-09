package jp.co.aforce.beans;
/**
 * 情報修正用Been
 * 
 */
public class UpdateUserBeen {
	private String lastName;//名前_姓
	private String firstName;//名前_名
	private String address;//住所
	private String mailAddress;//メースアドレス
	
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
