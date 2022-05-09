package com.candyshop.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Map;

public class ShoppingDAO implements IShoppingDAO {

	public int totalPrice(int id) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String query = "select price from candies_list where choco_id=?";
		statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		result = statement.executeQuery();
		int price = 0;
		while (result.next()) {
			price = result.getInt("price");
		}
		return price;
	}

	public void orderInsertions(int order_id, int user_id, Map<Integer, Integer> list) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement statement = null;
//		ResultSet result=null;
//		Date date = Date.valueOf(LocalDate.now());
//		String query="insert into candy_trans(user_id,choco_id,purchased_on,payment_mode)values(?,?,?,?)";
//		statement=connection.prepareStatement(query);
//		statement.setInt(1, 2);
//		statement.setInt(2, id);
//		statement.setDate(3, date);
//		statement.setString(4, paymentMode);
		for (Integer choco_id : list.keySet()) {
			Integer choco_quantity = list.get(choco_id);
			String query = "INSERT INTO candies_trans (order_id,user_id,choco_id,choco_quantity) VALUES(?,?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setInt(1, order_id);
			statement.setInt(2, user_id);
			statement.setInt(3, choco_id);
			statement.setInt(4, choco_quantity);
			statement.executeUpdate();
		}
	}
	public void chocoQuantity(Map<Integer,Integer> list) throws Exception{
		Connection connect = ConnectionUtil.getConnection();
		PreparedStatement statement = null;
		for(Integer i:list.keySet()) {
		String query = "update candies_list set set quantity=? where choco_id=?";
		statement = connect.prepareStatement(query);
		
		statement.executeUpdate();
		}
	}
}
