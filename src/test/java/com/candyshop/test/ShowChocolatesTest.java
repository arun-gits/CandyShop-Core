package com.candyshop.test;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.candyshop.dao.CandiesDAO;
import com.candyshop.logic.AddChocolates;
import com.candyshop.logic.ShowChocolates;
@SuppressWarnings("unused")
public class ShowChocolatesTest {
	private static Logger log=LogManager.getLogger(ShowChocolatesTest.class);

	public static void main (String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		Scanner dc=new Scanner(System.in);
		int choice=0;
		CandiesDAO menu=new CandiesDAO();
		log.info("1. Show all chocolates");
		log.info("2. Find by name");
		log.info("3. Search by name alike");
		log.info("4. Sort by price");
		log.info("Enter your input:");
		choice=sc.nextInt();
		switch(choice) {
		 
			case 1:
				try {
				ShowChocolates.list(menu.listAllChocolates());
				}catch(Exception e) {
					log.warn(e.getMessage());
				}
				
				break;
				
			case 2:
				try {
				log.info("Search by name:");
				String name=dc.nextLine();
				ShowChocolates.list(menu.findByName(name));
				}catch(Exception e) {
					log.warn(e.getMessage());
				}
				break;
				
			case 3:
				try {
				log.info("Search:");
				String choco=dc.nextLine();
				ShowChocolates.list(menu.findNameAlike(choco));
				}catch(Exception e) {
					log.warn(e.getMessage());
				}
				break;
				
			case 4:
				try {
				log.info("1. Price in ascending");
				log.info("2. Price in descending");
				log.info("Enter your choice:");
				int opt=sc.nextInt();
				if(opt==1) {
					ShowChocolates.list(menu.sortPriceInAsc());
				}
				else if(opt==2) {
					ShowChocolates.list(menu.sortPriceInDesc());
				}
				else {
					log.info("Wrong input");
					System.exit(1);
				}
				}catch(Exception e) {
					log.warn(e.getMessage());
				}
				break;
			
			default:
				log.info("Wrong input");
				System.exit(1);
			
		}
		sc.close();
		dc.close();
//		ShowChocolates.list(menu.findByName("crunch"));
	

	}
}
