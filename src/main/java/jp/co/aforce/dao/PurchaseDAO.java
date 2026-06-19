package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import jp.co.aforce.beans.Item;

public class PurchaseDAO extends DAO{
	public boolean insert(List<Item> cart,String name,String address) throws Exception {
		Connection con = getConnection();
		con.setAutoCommit(false);
		
		for(Item item : cart) {
			PreparedStatement ps = con.prepareStatement
					("");
		}
		
		
		return false;
	}
}
