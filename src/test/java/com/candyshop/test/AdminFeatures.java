package com.candyshop.test;

import java.util.Scanner;

import com.candyshop.dao.CandiesDAO;

public class AdminFeatures {
	static Scanner sc=new Scanner(System.in);
	static Scanner dc=new Scanner(System.in);
	
	public static void main(String[] args) {
		CandiesDAO candy=new CandiesDAO();
		System.out.println("1. Add chocolates");
		System.out.println("2. Delete chocolates");
		System.out.println("3. Update price");
		System.out.println("4. Exit\n");
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		switch(choice) {
		
			case 1:
				System.out.println("Enter chocolate name:");
				String name=dc.nextLine();
				System.out.println("Enter price:");
				int price=sc.nextInt();
				try {
					candy.addChocolates(name, price);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					//e.printStackTrace();
				}
				break;
				
			case 2:
				System.out.println("Enter chocolate name:");
				String chocolate=dc.nextLine();
				try {
					candy.deleteChocolates(chocolate);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					//e.printStackTrace();
				}
				break;
				
			case 3:
				System.out.println("Enter chocolate id:");
				int choco=dc.nextInt();
				System.out.println("Enter price to update");
				int cost=sc.nextInt();
				try {
					candy.updatePrice(cost,choco);
				}catch(Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				break;
				
			default:
				System.out.println("Wrong input\nRefresh the page");
				System.exit(1);
				
		}
	}

}
