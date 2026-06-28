package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ProductBean;

public class ProductSortDAO extends DAO {

	public List<ProductBean> serch(String[] categorys, String[] paws, String sort) throws Exception {

		Connection con = getConnection();


		StringBuilder sql = new StringBuilder(
				"SELECT product_id,p.category_id,po.paw_id,c.name,p.name,price,stock,description,fileName,paw_name,paw_description "
				+ "FROM products p JOIN categories c "
				+ "ON p.category_id = c.category_id "
				+ "JOIN paw_types po "
				+ "ON p.paw_id = po.paw_id "
				+ "WHERE 1 = 1 "
		);


		List<Object> params = new ArrayList<>();


		//カテゴリー複数
		if (categorys != null && categorys.length > 0) {

			sql.append("AND p.category_id IN (");


			for (int i = 0; i < categorys.length; i++) {

				sql.append("?");

				if (i < categorys.length - 1)
					sql.append(",");


				params.add(Integer.parseInt(categorys[i]));

			}


			sql.append(") ");

		}




		//肉球複数
		if (paws != null && paws.length > 0) {


			sql.append("AND p.paw_id IN (");


			for (int i = 0; i < paws.length; i++) {


				sql.append("?");


				if (i < paws.length - 1)
					sql.append(",");


				params.add(Integer.parseInt(paws[i]));

			}


			sql.append(") ");

		}




		//並び替え
		if ("name".equals(sort))
			sql.append("ORDER BY p.name");


		if ("low".equals(sort))
			sql.append("ORDER BY price");


		if ("high".equals(sort))
			sql.append("ORDER BY price desc");



		PreparedStatement ps = con.prepareStatement(sql.toString());



		for (int i = 0; i < params.size(); i++) {

			ps.setObject(i + 1, params.get(i));

		}



		ResultSet rs = ps.executeQuery();



		List<ProductBean> list = new ArrayList<>();



		while (rs.next()) {


			ProductBean p = new ProductBean();


			p.setProductId(rs.getInt("product_id"));

			p.setCategoryId(rs.getInt("category_id"));

			p.setPawId(rs.getInt("paw_id"));

			p.setCategoryName(rs.getString("c.name"));

			p.setName(rs.getString("p.name"));

			p.setPawName(rs.getString("paw_name"));

			p.setPrice(rs.getInt("price"));


			// 在庫数
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

}