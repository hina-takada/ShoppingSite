package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.Item;
import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.beans.PurchaseProductBean;
import jp.co.aforce.beans.User;

public class PurchaseDAO extends DAO {

	public boolean insert(List<Item> cart, int tax, int totalTax, int shippingFee, int grandTotal, String userid,
			String lastName, String firstName, String address, String orderId) throws Exception {

		Connection con = getConnection();
		con.setAutoCommit(false);

		for (Item item : cart) {

			ProductBean p = item.getProduct();

			// 在庫減算
			PreparedStatement stockPs = con.prepareStatement(
					"UPDATE products SET stock = stock - ? WHERE product_id = ? AND stock >= ?");

			stockPs.setInt(1, item.getCount());
			stockPs.setInt(2, p.getProductId());
			stockPs.setInt(3, item.getCount());

			int stockLine = stockPs.executeUpdate();

			stockPs.close();

			// 在庫不足
			if (stockLine != 1) {

				con.rollback();
				con.setAutoCommit(true);
				con.close();

				return false;
			}

			PreparedStatement ps = con.prepareStatement(
					"insert into purchase("
							+ "product_id,order_id,product_name,product_price,"
							+ "product_subtotal,product_count,product_tax,"
							+ "product_totaltax,shipping_fee,product_grand_total,"
							+ "user_id,user_last_name,user_first_name,user_address)"
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setInt(1, p.getProductId());
			ps.setString(2, orderId);
			ps.setString(3, p.getName());
			ps.setInt(4, p.getPrice());
			ps.setInt(5, item.getSubTotal());

			// 購入数量
			ps.setInt(6, item.getCount());

			ps.setInt(7, tax);
			ps.setInt(8, totalTax);
			ps.setInt(9, shippingFee);
			ps.setInt(10, grandTotal);

			ps.setString(11, userid);
			ps.setString(12, lastName);
			ps.setString(13, firstName);
			ps.setString(14, address);

			int line = ps.executeUpdate();

			ps.close();

			if (line != 1) {

				con.rollback();
				con.setAutoCommit(true);
				con.close();

				return false;
			}
		}

		con.commit();
		con.setAutoCommit(true);
		con.close();

		return true;

	}

	/**
	 * 購入完了画面用
	 */
	public List<PurchaseProductBean> serch(String orderId) throws Exception {

		Connection con = getConnection();

		List<PurchaseProductBean> list = new ArrayList<>();

		PreparedStatement ps = con.prepareStatement(
				"select pu.product_id,order_id,product_name,"
						+ "product_price,product_subtotal,product_count,"
						+ "product_tax,product_totaltax,shipping_fee,"
						+ "product_grand_total,user_id,"
						+ "user_last_name,user_first_name,user_address,fileName "
						+ "from purchase pu "
						+ "join products p "
						+ "on pu.product_id = p.product_id "
						+ "where order_id = ?");

		ps.setString(1, orderId);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			PurchaseProductBean pur = new PurchaseProductBean();

			ProductBean p = pur.getProduct();

			User u = pur.getUser();

			p.setProductId(rs.getInt("product_id"));

			pur.setOrderId(rs.getString("order_id"));

			p.setName(rs.getString("product_name"));

			p.setPrice(rs.getInt("product_price"));

			pur.setSubTotal(rs.getInt("product_subtotal"));

			// 購入数量
			pur.setCount(rs.getInt("product_count"));

			pur.setTax(rs.getInt("product_tax"));

			pur.setTotalTax(rs.getInt("product_totaltax"));

			pur.setShippingFee(rs.getInt("shipping_fee"));

			pur.setGrandTotal(rs.getInt("product_grand_total"));

			u.setLastName(rs.getString("user_last_name"));

			u.setFirstName(rs.getString("user_first_name"));

			u.setAddress(rs.getString("user_address"));

			p.setFileName(rs.getString("fileName"));

			list.add(pur);
		}

		rs.close();
		ps.close();
		con.close();

		return list;
	}

	/**
	 * 在庫確認
	 */
	public boolean hasStock(int productId, int count) throws Exception {

		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement(
				"SELECT stock FROM products WHERE product_id = ?");

		ps.setInt(1, productId);

		ResultSet rs = ps.executeQuery();

		boolean result = false;

		if (rs.next()) {

			result = rs.getInt("stock") >= count;

		}

		rs.close();
		ps.close();
		con.close();

		return result;
	}

	/**
	 * 購入履歴用
	 */
	public List<PurchaseProductBean> historySerch(String string) throws Exception {

		Connection con = getConnection();

		List<PurchaseProductBean> list = new ArrayList<>();

		PreparedStatement ps = con.prepareStatement(
				"select pu.REGIST_DATE,product_name,"
						+ "product_price,product_subtotal,"
						+ "product_count,product_tax,"
						+ "product_totaltax,shipping_fee,"
						+ "product_grand_total,"
						+ "user_last_name,user_first_name,"
						+ "user_address,fileName "
						+ "from purchase pu "
						+ "join products p "
						+ "on pu.product_id = p.product_id "
						+ "where user_id = ? "
						+ "order by REGIST_DATE desc");

		ps.setString(1, string);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			PurchaseProductBean pur = new PurchaseProductBean();

			ProductBean p = pur.getProduct();

			User u = pur.getUser();

			p.setName(rs.getString("product_name"));

			p.setPrice(rs.getInt("product_price"));

			pur.setSubTotal(rs.getInt("product_subtotal"));

			// 購入数量
			pur.setCount(rs.getInt("product_count"));

			pur.setTax(rs.getInt("product_tax"));

			pur.setTotalTax(rs.getInt("product_totaltax"));

			pur.setShippingFee(rs.getInt("shipping_fee"));

			pur.setGrandTotal(rs.getInt("product_grand_total"));

			u.setLastName(rs.getString("user_last_name"));

			u.setFirstName(rs.getString("user_first_name"));

			u.setAddress(rs.getString("user_address"));

			p.setFileName(rs.getString("fileName"));

			pur.setRegistdate(
					rs.getTimestamp("REGIST_DATE").toLocalDateTime());

			list.add(pur);

		}

		rs.close();
		ps.close();
		con.close();

		return list;

	}

}