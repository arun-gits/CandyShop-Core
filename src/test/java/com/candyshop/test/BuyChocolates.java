package com.candyshop.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.candyshop.dao.CandiesDAO;
import com.candyshop.dao.ShoppingDAO;
import com.candyshop.logic.Payment;
import com.candyshop.model.Chocolates;

public class BuyChocolates {

	static List<Integer> chocoId = null;
	static Scanner sc = new Scanner(System.in);

	public static void allChocolates() throws Exception {

		CandiesDAO obj = new CandiesDAO();
		List<Chocolates> choco = obj.listAllChocolates();
		for (Chocolates chocolate : choco) {
			System.out.println(chocolate.getId() + " " + chocolate.getName() + " =>" + chocolate.getPrice());
		}
		chocoId = new ArrayList<Integer>();

		buyChocolates();

	}

	public static void buyChocolates() throws Exception {

		ShoppingDAO shop = new ShoppingDAO();
		System.out.println("\nSelect the chocolate by using the id");
		System.out.println("Enter 0 for exit and continue to payment");
		int totalPrice = 0;
		int price = 0;
		while (sc.hasNext()) {
			int id = sc.nextInt();
			if (id == 0) {
				break;
			} else {
				chocoId.add(id);
			}
		}
		for (Integer id : chocoId) {
			price = shop.totalPrice(id);
			totalPrice = totalPrice + price;
		}
		System.out.println("your total price is " + totalPrice);
		System.out.println("1) Continue to payment");
		System.out.println("2) Continue shopping\n");
		int option = sc.nextInt();
		if (option == 1) {
			String paymentMode = Payment.PayMode();
			int verified = totalAmount(totalPrice);
			if (verified == 1) {
				System.out.println("Payment completed");
				Map<Integer, Integer> quants = quantity(chocoId);
				
				// shop.orderInsertions(order_id, 2, quants);
				System.out.println("Order placed Successfully");
			}
		} else if (option == 2) {
			buyChocolates();
		}

	}

	public static int totalAmount(int total) throws Exception {

		int result = 1;

		System.out.println("Enter amount to pay");
		int price = sc.nextInt();

		if (price > total || price < total) {
			System.out.println("Please pay " + total);
			totalAmount(total);
		} else if (price == total) {

			return result;
		}
		return result;

	}

	public static Map<Integer, Integer> quantity(List<Integer> list) {
		CandiesDAO candy = new CandiesDAO();
		Map<Integer, Integer> quants = new TreeMap<Integer, Integer>();
		int n = 0;
		try {
			n = candy.count();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int j = 1; j < n; j++) {
			int count = 0;
			for (Integer i : list) {							
				if(j==i) {
					count++;
				}
			}
			if(count!=0) {
				quants.put(j, count);
			}
		}
		return quants;
	}

	public static void main(String[] args) throws Exception {
		BuyChocolates.allChocolates();
	}
}
