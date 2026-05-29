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
	 * 全データを取得
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
			/*u.setFirstName(rs.getString("FIRST_NAME"));
			u.setAddress(rs.getString("ADDRESS"));
			u.setMailAddress(rs.getString("MAIL_ADDRESS"));*/
		}
		
		ps.close();
		con.close();
		return u;
	}
	
}
