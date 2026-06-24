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
	public User serch(String id, String pass) throws Exception {
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

		rs.close();
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
	public boolean insert(String id, String pass, String lastName,
			String firstName, String address, String mailAddress) throws Exception {
		String sql = "INSERT INTO users (MEMBER_ID,PASSWORD,LAST_NAME,FIRST_NAME,ADDRESS,MAIL_ADDRESS) VALUES (?,?,?,?,?,?)";
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, id);
			ps.setString(2, pass);
			ps.setString(3, lastName);
			ps.setString(4, firstName);
			ps.setString(5, address);
			ps.setString(6, mailAddress);
			int line = ps.executeUpdate();

			if (line < 0) {
				return false;
			}
			return true;
		}
	}

	/**
	 * 同じIDとPASSの組み合わせがあるかどうか
	 * 
	 * @param id
	 * @throws Exception
	 */
	public boolean userCheck(String id) throws Exception {

		String sql = "SELECT MEMBER_ID FROM users WHERE MEMBER_ID = ?";
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, id);

			try (ResultSet rs = ps.executeQuery();) {

				if (rs.next()) {
					return true;
				}
				
				return false;
			}
			
		}
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
	public boolean update(String id, String upId, String pass, String lastName,
			String firstName, String address, String mailAddress) throws Exception {
		String sql = "UPDATE users SET MEMBER_ID = ?,PASSWORD = ?, LAST_NAME = ?,FIRST_NAME = ?,ADDRESS = ?,MAIL_ADDRESS = ?  WHERE MEMBER_ID = ?";
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, upId);
			ps.setString(2, pass);
			ps.setString(3, lastName);
			ps.setString(4, firstName);
			ps.setString(5, address);
			ps.setString(6, mailAddress);
			ps.setString(7, id);
			int line = ps.executeUpdate();

			if (line < 0) {
				return false;
			}

			return true;
		}

	}

	/**
	 * 会員登録の削除
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String id) throws Exception {
		String sql = "DELETE FROM users WHERE MEMBER_ID = ?";
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, id);
			int line = ps.executeUpdate();

			if (line < 0) {
				return false;
			}

			return true;
		}

	}
}
