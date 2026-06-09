package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ProductBean;

public class ProductDAO extends DAO {
	
	/**/
	public List<ProductBean> serch() throws Exception {
		List<ProductBean> list = new ArrayList<>();
		Connection con = getConnection();
		
		PreparedStatement ps = 
				con.prepareStatement("SELECT * FROM products ORDER BY name LIMIT 10");
		ResultSet rs =  ps.executeQuery();
		
		while (rs.next()) {
			ProductBean p = new ProductBean();
			p.setProductId(rs.getInt("product_id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			p.setCount(rs.getInt("count"));
			list.add(p);
		}
		
		return list;
	}
	
	/**
	 *商品登録 
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
	public boolean insert(String name,String price,String count) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps;
		
		ps = con.prepareStatement
			("INSERT INTO products (name,price,count) VALUES (?,?,?)");
		ps.setString(1, name);
		ps.setString(2, price);
		ps.setString(3, count);
		int line = ps.executeUpdate();
		
		if(line < 0) return false;
		
		ps.close();
		con.close();
		return true;		
	}
}
