package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.HomeBean;

public class HomeDAO extends DAO{
	public List<HomeBean> serch(String keyword) throws Exception {
		List<HomeBean> list = new ArrayList<>();
		Connection con = getConnection();
		
		PreparedStatement ps = 
				con.prepareStatement("SELECT product_id,p.category_id,c.name,p.name,price,count,description FROM products p join categories c "
						+ "on p.category_id = c.category_id where p.name like ? ORDER BY product_id");
		ps.setString(1, "%" +  keyword + "%");
		ResultSet rs =  ps.executeQuery();
		
		while (rs.next()) {
			HomeBean h = new HomeBean();
			h.setProductId(rs.getInt("product_id"));
			h.setCategoryId(rs.getInt("p.category_id"));
			h.setCategoryName(rs.getString("c.name"));
			h.setName(rs.getString("p.name"));
			h.setPrice(rs.getInt("price"));
			h.setCount(rs.getInt("count"));
			h.setDescription(rs.getString("description"));
			list.add(h);
		}
		
		ps.close();
		con.close();
		return list;
	}
}
