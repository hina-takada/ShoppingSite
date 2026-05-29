package jp.co.aforce.beans;

/**
 * 
 * usersデータベースのbean
 * 
 */
public class User {
	private String id;//会員番号
	private String pass;//パスワード
	private String lastName;//名前_姓
	private String firstName;//名前_名
	private String address;//住所
	private String mailAddress;//メースアドレス
	private String role;//権限(user/admin)
	
	
	/*
	 * idのget set
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	/*
	 * パスワードのget set
	 */
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/*
	 * 姓のget set
	 */
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/*
	 * 名のget set
	 */
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/*
	 * 住所のget set
	 */
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	/*
	 * メースアドレスのget set
	 */
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
	/**
	 * 権限のget set
	 * @return 権限を返す
	 */
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
