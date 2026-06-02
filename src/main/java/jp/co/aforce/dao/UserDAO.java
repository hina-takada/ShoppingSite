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
	public User login(String id,String pass) throws Exception{
		User u = null;
		Connection con = getConnection();
		
		PreparedStatement ps;
		ps = con.prepareStatement("select MEMBER_ID,PASSWORD,LAST_NAME,role from users where MEMBER_ID = ? AND PASSWORD = ?");
		ps.setString(1, id);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		
		
		
		while (rs.next()) {
			u = new User();
			u.setId(rs.getString("MEMBER_ID"));
			u.setPass(rs.getString("PASSWORD"));
			u.setLastName(rs.getString("LAST_NAME"));
			u.setRole(rs.getString("role"));
		}
		
		ps.close();
		con.close();
		return u;
	}
	
	
	public int insert(String id,String pass,String lastName,
			String firstName,String address,String mailAddress) throws Exception {
		
		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement
			("INSERT INTO users (MEMBER_ID,PASSWORD,LAST_NAME,FIRST_NAME,ADDRESS,MAIL_ADDRESS) VALUES (?,?,?,?,?,?)");
		ps.setString(1, id);
		ps.setString(2, pass);
		ps.setString(3, lastName);
		ps.setString(4, firstName);
		ps.setString(5, address);
		ps.setString(6, mailAddress);
		int line = ps.executeUpdate();
		
		
		
		return line;		
	}
}
