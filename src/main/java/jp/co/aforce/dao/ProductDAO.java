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
	 */
	public List<ProductBean> serch() throws Exception {

		List<ProductBean> list = new ArrayList<>();

		Connection con = getConnection();


		PreparedStatement ps = con.prepareStatement(
				"SELECT product_id,p.category_id,po.paw_id,c.name,p.name,price,stock,description,fileName,paw_name,paw_description "
				+ "FROM products p JOIN categories c "
				+ "ON p.category_id = c.category_id "
				+ "JOIN paw_types po "
				+ "ON p.paw_id = po.paw_id "
				+ "ORDER BY product_id"
		);


		ResultSet rs = ps.executeQuery();


		while(rs.next()) {

			ProductBean p = new ProductBean();

			p.setProductId(rs.getInt("product_id"));
			p.setCategoryId(rs.getInt("category_id"));
			p.setPawId(rs.getInt("paw_id"));
			p.setCategoryName(rs.getString("c.name"));
			p.setName(rs.getString("p.name"));
			p.setPawName(rs.getString("paw_name"));
			p.setPrice(rs.getInt("price"));

			p.setStock(rs.getInt("stock"));

			p.setDescription(rs.getString("description"));
			p.setPawDescription(rs.getString("paw_description"));
			p.setFileName(rs.getString("fileName"));

			list.add(p);
		}


		rs.close();
		ps.close();
		con.close();

		return list;
	}




	/**
	 * 商品検索
	 */
	public List<ProductBean> serch(String keyword) throws Exception {


		List<ProductBean> list = new ArrayList<>();

		Connection con = getConnection();


		PreparedStatement ps = con.prepareStatement(
				"SELECT product_id,p.category_id,po.paw_id,c.name,p.name,price,stock,description,fileName,paw_name,paw_description "
				+ "FROM products p JOIN categories c "
				+ "ON p.category_id = c.category_id "
				+ "JOIN paw_types po "
				+ "ON p.paw_id = po.paw_id "
				+ "WHERE p.name LIKE ? "
				+ "ORDER BY product_id"
		);


		ps.setString(1, "%" + keyword + "%");


		ResultSet rs = ps.executeQuery();



		while(rs.next()) {


			ProductBean p = new ProductBean();


			p.setProductId(rs.getInt("product_id"));
			p.setCategoryId(rs.getInt("category_id"));
			p.setPawId(rs.getInt("paw_id"));
			p.setCategoryName(rs.getString("c.name"));
			p.setName(rs.getString("p.name"));
			p.setPawName(rs.getString("paw_name"));
			p.setPrice(rs.getInt("price"));

			p.setStock(rs.getInt("stock"));

			p.setDescription(rs.getString("description"));
			p.setPawDescription(rs.getString("paw_description"));
			p.setFileName(rs.getString("fileName"));


			list.add(p);

		}


		rs.close();
		ps.close();
		con.close();


		return list;
	}






	/**
	 * 商品詳細取得
	 */
	public ProductBean productSerch(int productId) throws Exception {


		ProductBean p = null;


		Connection con = getConnection();



		PreparedStatement ps = con.prepareStatement(
				"SELECT product_id,p.category_id,po.paw_id,c.name,p.name,price,stock,description,fileName,paw_name,paw_description "
				+ "FROM products p JOIN categories c "
				+ "ON p.category_id = c.category_id "
				+ "JOIN paw_types po "
				+ "ON p.paw_id = po.paw_id "
				+ "WHERE product_id = ?"
		);


		ps.setInt(1, productId);


		ResultSet rs = ps.executeQuery();



		while(rs.next()) {


			p = new ProductBean();


			p.setProductId(rs.getInt("product_id"));
			p.setCategoryId(rs.getInt("category_id"));
			p.setPawId(rs.getInt("paw_id"));
			p.setCategoryName(rs.getString("c.name"));
			p.setName(rs.getString("p.name"));
			p.setPawName(rs.getString("paw_name"));
			p.setPrice(rs.getInt("price"));

			p.setStock(rs.getInt("stock"));

			p.setDescription(rs.getString("description"));
			p.setPawDescription(rs.getString("paw_description"));
			p.setFileName(rs.getString("fileName"));

		}


		rs.close();
		ps.close();
		con.close();


		return p;

	}





	/**
	 * 総件数
	 */
	public int countAll() throws Exception {


		String sql = "SELECT count(*) FROM products";


		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){


			if(rs.next()) {

				return rs.getInt(1);

			}

			return 0;
		}

	}





	/**
	 * 商品管理一覧
	 */
	public List<ProductBean> serchManerger(int limit,int offset) throws Exception {


		List<ProductBean> list = new ArrayList<>();

		Connection con = getConnection();


		PreparedStatement ps = con.prepareStatement(
				"SELECT product_id,p.category_id,po.paw_id,c.name,p.name,price,stock,description,fileName,paw_name,paw_description "
				+ "FROM products p JOIN categories c "
				+ "ON p.category_id = c.category_id "
				+ "JOIN paw_types po "
				+ "ON p.paw_id = po.paw_id "
				+ "ORDER BY product_id LIMIT ? OFFSET ?"
		);


		ps.setInt(1, limit);
		ps.setInt(2, offset);



		ResultSet rs = ps.executeQuery();



		while(rs.next()) {


			ProductBean p = new ProductBean();


			p.setProductId(rs.getInt("product_id"));
			p.setCategoryId(rs.getInt("category_id"));
			p.setPawId(rs.getInt("paw_id"));

			p.setCategoryName(rs.getString("c.name"));
			p.setName(rs.getString("p.name"));

			p.setPawName(rs.getString("paw_name"));

			p.setPrice(rs.getInt("price"));
			p.setStock(rs.getInt("stock"));

			p.setDescription(rs.getString("description"));
			p.setPawDescription(rs.getString("paw_description"));

			p.setFileName(rs.getString("fileName"));


			list.add(p);

		}


		ps.close();
		con.close();


		return list;

	}





	/**
	 * 商品登録
	 */
	public boolean insert(String name,int price,int stock,int categoryId,
			String description,String fileName,int pawId) throws Exception {


		String sql =
				"INSERT INTO products "
				+ "(name,price,stock,category_id,description,fileName,paw_id) "
				+ "VALUES (?,?,?,?,?,?,?)";



		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){


			ps.setString(1,name);
			ps.setInt(2,price);
			ps.setInt(3,stock);
			ps.setInt(4,categoryId);
			ps.setString(5,description);
			ps.setString(6,fileName);
			ps.setInt(7,pawId);


			return ps.executeUpdate() > 0;

		}

	}






	/**
	 * 商品更新
	 */
	public boolean update(int productId,String name,int categoryId,int price,int stock,
			String description,String fileName,int pawId) throws Exception {


		String sql =
				"UPDATE products SET "
				+ "name=?,price=?,stock=?,category_id=?,description=?,fileName=?,paw_id=? "
				+ "WHERE product_id=?";



		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){


			ps.setString(1,name);
			ps.setInt(2,price);
			ps.setInt(3,stock);
			ps.setInt(4,categoryId);
			ps.setString(5,description);
			ps.setString(6,fileName);
			ps.setInt(7,pawId);
			ps.setInt(8,productId);



			return ps.executeUpdate() > 0;

		}

	}






	/**
	 * 更新検索
	 */
	public UpdateProductBeen updateSerch(int productId) throws Exception {


		UpdateProductBeen p = null;


		Connection con = getConnection();


		PreparedStatement ps = con.prepareStatement(
				"SELECT product_id,p.category_id,po.paw_id,c.name,p.name,price,stock,description,fileName,paw_name,paw_description "
				+ "FROM products p JOIN categories c "
				+ "ON p.category_id=c.category_id "
				+ "JOIN paw_types po "
				+ "ON p.paw_id=po.paw_id "
				+ "WHERE product_id=?"
		);


		ps.setInt(1,productId);


		ResultSet rs = ps.executeQuery();



		while(rs.next()) {


			p = new UpdateProductBeen();


			p.setProductId(rs.getInt("product_id"));
			p.setCategoryId(rs.getInt("category_id"));
			p.setPawId(rs.getInt("paw_id"));
			p.setCategoryName(rs.getString("c.name"));
			p.setName(rs.getString("p.name"));
			p.setPawName(rs.getString("paw_name"));
			p.setPrice(rs.getInt("price"));

			p.setStock(rs.getInt("stock"));

			p.setDescription(rs.getString("description"));
			p.setPawDescription(rs.getString("paw_description"));
			p.setFileName(rs.getString("fileName"));

		}


		rs.close();
		ps.close();
		con.close();


		return p;

	}





	public boolean delete(int id) throws Exception {


		String sql =
				"DELETE FROM products WHERE product_id = ?";



		try(Connection con=getConnection();
				PreparedStatement ps=con.prepareStatement(sql)){


			ps.setInt(1,id);


			return ps.executeUpdate() > 0;

		}

	}

}