package com.candyshop.dao;

import java.util.Map;

public interface IShoppingDAO {
	

	int totalPrice(int id) throws Exception;
	//Shows total price after the insertion
	
	public void orderInsertions(int order_id, int user_id, Map<Integer, Integer> list) throws Exception;
}
