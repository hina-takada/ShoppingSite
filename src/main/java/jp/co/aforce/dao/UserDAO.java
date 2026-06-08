package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.User;

/**
 * データベースの取得
 */
public class UserDAO extends DAO {
	
	/**
	 * ログインするデータを取得
	 * 
	 * @param id　入力されたIDを取得
	 * @param pass　入力されたPS
	 * @throws Exception
	 */
	public User serch(String id,String pass) throws Exception{
		User u = null;
		Connection con = getConnection();
		
		PreparedStatement ps;
		ps = con.prepareStatement("select * from users where MEMBER_ID = ? AND PASSWORD = ?");
		ps.setString(1, id);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			u = new User();
			u.setId(rs.getString("MEMBER_ID"));
			u.setPass(rs.getString("PASSWORD"));
			u.setLastName(rs.getString("LAST_NAME"));
			u.setFirstName(rs.getString("FIRST_NAME"));
			u.setAddress(rs.getString("ADDRESS"));
			u.setMailAddress(rs.getString("MAIL_ADDRESS"));
			u.setRole(rs.getString("role"));
		}
		
		ps.close();
		con.close();
		return u;
	}
	
	/**
	 *新規会員登録 
	 * 
	 * @param id
	 * @param pass
	 * @param lastName
	 * @param firstName
	 * @param address
	 * @param mailAddress
	 * @return
	 * @throws Exception
	 */
	public boolean insert(String id,String pass,String lastName,
			String firstName,String address,String mailAddress) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps;
		
		ps = con.prepareStatement
			("INSERT INTO users (MEMBER_ID,PASSWORD,LAST_NAME,FIRST_NAME,ADDRESS,MAIL_ADDRESS) VALUES (?,?,?,?,?,?)");
		ps.setString(1, id);
		ps.setString(2, pass);
		ps.setString(3, lastName);
		ps.setString(4, firstName);
		ps.setString(5, address);
		ps.setString(6, mailAddress);
		int line = ps.executeUpdate();
		
		if(line < 0) return false;
		
		ps.close();
		con.close();
		return true;		
	}
	/**
	 * 同じIDとPASSの組み合わせがあるかどうか
	 * 
	 * @param id
	 * @throws Exception
	 */
	public boolean userCheck(String id) throws Exception {
		User u = null; 
		Connection con = getConnection();
		PreparedStatement ps;
		
		ps = con.prepareStatement
				("SELECT MEMBER_ID FROM users WHERE MEMBER_ID = ?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) return true;
		
		ps.close();
		con.close();
		return false;
	}
	
	/**
	 * 会員情報の編集（更新）
	 * 
	 * @param id
	 * @param pass
	 * @param lastName
	 * @param firstName
	 * @param address
	 * @param mailAddress
	 * @return
	 * @throws Exception
	 */
	public boolean update(String id,String lastName,
			String firstName,String address,String mailAddress) throws Exception {
		
		Connection con = getConnection();
		PreparedStatement ps;
		
		ps = con.prepareStatement
			("UPDATE users SET LAST_NAME = ?,FIRST_NAME = ?,ADDRESS = ?,MAIL_ADDRESS = ?  WHERE MEMBER_ID = ?");
		ps.setString(1, lastName);
		ps.setString(2, firstName);
		ps.setString(3, address);
		ps.setString(4, mailAddress);
		ps.setString(5, id);
		int line =  ps.executeUpdate();
		
		if (line < 0)return false;
		
		ps.close();
		con.close();
		return true;		
	}
	
	/**
	 * 会員登録の削除
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String id) throws Exception {
		
		Connection con = getConnection();
		PreparedStatement ps;
		
		ps = con.prepareStatement("DELETE FROM users WHERE MEMBER_ID = ?");
		ps.setString(1, id);
		int line = ps.executeUpdate();
		
		if(line < 0)return false;
		
		ps.close();
		con.close();
		return true;
	}
}
