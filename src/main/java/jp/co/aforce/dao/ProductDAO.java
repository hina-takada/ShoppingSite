package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.beans.UpdateProductBeen;

public class ProductDAO extends DAO {
	/**
	 * 商品一覧取得
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ProductBean> serch() throws Exception {
		List<ProductBean> list = new ArrayList<>();
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement(
				"SELECT product_id,p.category_id,c.name,p.name,price,count,description,fileName FROM products p join categories c "
						+ "on p.category_id = c.category_id ORDER BY product_id");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ProductBean p = new ProductBean();
			p.setProductId(rs.getInt("product_id"));
			p.setCategoryId(rs.getInt("category_id"));
			p.setCategoryName(rs.getString("c.name"));
			p.setName(rs.getString("p.name"));
			p.setPrice(rs.getInt("price"));
			p.setCount(rs.getInt("count"));
			p.setDescription(rs.getString("description"));
			p.setFileName(rs.getString("fileName"));
			list.add(p);
		}

		ps.close();
		con.close();
		return list;
	}

	/**
	 * 商品検索
	 * 
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public List<ProductBean> serch(String keyword) throws Exception {
		List<ProductBean> list = new ArrayList<>();
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement(
				"SELECT product_id,p.category_id,c.name,p.name,price,count,description,fileName FROM products p join categories c "
						+ "on p.category_id = c.category_id where p.name like ? ORDER BY product_id");
		ps.setString(1, "%" + keyword + "%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ProductBean p = new ProductBean();
			p.setProductId(rs.getInt("product_id"));
			p.setCategoryId(rs.getInt("p.category_id"));
			p.setCategoryName(rs.getString("c.name"));
			p.setName(rs.getString("p.name"));
			p.setPrice(rs.getInt("price"));
			p.setCount(rs.getInt("count"));
			p.setDescription(rs.getString("description"));
			p.setFileName(rs.getString("fileName"));
			list.add(p);
		}

		ps.close();
		con.close();
		return list;
	}

	/**
	 * 
	 * 
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public ProductBean productSerch(int productId) throws Exception {
		ProductBean p = null;
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement(
				"SELECT product_id,p.category_id,c.name,p.name,price,count,description,fileName FROM products p join categories c "
						+ "on p.category_id = c.category_id WHERE product_id = ?");
		ps.setInt(1, productId);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			p = new ProductBean();
			p.setProductId(rs.getInt("product_id"));
			p.setCategoryId(rs.getInt("p.category_id"));
			p.setName(rs.getString("p.name"));
			p.setCategoryName(rs.getString("c.name"));
			p.setPrice(rs.getInt("price"));
			p.setCount(rs.getInt("count"));
			p.setDescription(rs.getString("description"));
			p.setFileName(rs.getString("fileName"));
		}

		ps.close();
		con.close();
		return p;
	}
	
	/**
	 * 総件数を取得	
	 */
	public int countAll() throws Exception {
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement
				("SELECT count(*) FROM products");
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())return rs.getInt(1);
		
		return 0;
	}

	
	/**
	 * 商品一覧取得(商品管理用)
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ProductBean> serchManerger(int limit,int offset) throws Exception {
		List<ProductBean> list = new ArrayList<>();
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement(
				"SELECT product_id,p.category_id,c.name,p.name,price,count,description,fileName FROM products p join categories c "
						+ "on p.category_id = c.category_id ORDER BY product_id LIMIT ? offset ?");
		ps.setInt(1, limit);
		ps.setInt(2, offset);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ProductBean p = new ProductBean();
			p.setProductId(rs.getInt("product_id"));
			p.setCategoryId(rs.getInt("category_id"));
			p.setCategoryName(rs.getString("c.name"));
			p.setName(rs.getString("p.name"));
			p.setPrice(rs.getInt("price"));
			p.setCount(rs.getInt("count"));
			p.setDescription(rs.getString("description"));
			p.setFileName(rs.getString("fileName"));
			list.add(p);
		}

		ps.close();
		con.close();
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
	public boolean insert(String name, int price, int count, int categoryId, String description, String fileName)
			throws Exception {
		Connection con = getConnection();
		PreparedStatement ps;

		ps = con.prepareStatement(
				"INSERT INTO products (name,price,count,category_id,description,fileName) VALUES (?,?,?,?,?,?)");
		ps.setString(1, name);
		ps.setInt(2, price);
		ps.setInt(3, count);
		ps.setInt(4, categoryId);
		ps.setString(5, description);
		ps.setString(6, fileName);
		int line = ps.executeUpdate();

		if (line < 0)
			return false;

		ps.close();
		con.close();
		return true;
	}

	/**
	 * IDからカテゴリー名を取得
	 * 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public String getCategoryName(int id) throws Exception {
		String categoryName = null;

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT name FROM categories WHERE category_id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			categoryName = rs.getString("name");
		}

		ps.close();
		con.close();
		return categoryName;
	}

	/**
	 * 商品情報の編集（更新）
	 * 
	 * @param i
	 * @param pass
	 * @param lastName
	 * @param firstName
	 * @param j
	 * @param k
	 * @return
	 * @throws Exception
	 */
	public boolean update(int productId, String name, int categoryId, int price, int count, String description,
			String fileName) throws Exception {

		Connection con = getConnection();
		PreparedStatement ps;

		ps = con.prepareStatement(
				"UPDATE products SET name = ?,price = ?,count = ?,category_id = ?, description = ?,fileName = ?  WHERE product_id = ?");
		ps.setString(1, name);
		ps.setInt(2, price);
		ps.setInt(3, count);
		ps.setInt(4, categoryId);
		ps.setString(5, description);
		ps.setString(6, fileName);
		ps.setInt(7, productId);
		int line = ps.executeUpdate();

		if (line < 0)
			return false;

		ps.close();
		con.close();
		return true;
	}

	/**
	 * 更新用の検索
	 * 
	 * @return
	 * @throws Exception
	 */
	public UpdateProductBeen updateSerch(int productId) throws Exception {
		UpdateProductBeen p = null;
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement(
				"SELECT product_id,p.category_id,c.name,p.name,price,count,description,fileName FROM products p join categories c "
						+ "on p.category_id = c.category_id WHERE product_id = ?");
		ps.setInt(1, productId);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			p = new UpdateProductBeen();
			p.setProductId(rs.getInt("product_id"));
			p.setCategoryId(rs.getInt("p.category_id"));
			p.setName(rs.getString("p.name"));
			p.setCategoryName(rs.getString("c.name"));
			p.setPrice(rs.getInt("price"));
			p.setCount(rs.getInt("count"));
			p.setDescription(rs.getString("description"));
			p.setFileName(rs.getString("fileName"));
		}

		ps.close();
		con.close();
		return p;
	}

	/**
	 * 商品登録の削除
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(int id) throws Exception {

		Connection con = getConnection();
		PreparedStatement ps;

		ps = con.prepareStatement("DELETE FROM products WHERE product_id = ?");
		ps.setInt(1, id);
		int line = ps.executeUpdate();

		if (line < 0)
			return false;

		ps.close();
		con.close();
		return true;
	}
}
