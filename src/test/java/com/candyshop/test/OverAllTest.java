package com.candyshop.test;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.candyshop.logic.MainClass;

public class OverAllTest {
	private static Logger log=LogManager.getLogger(OverAllTest.class);
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		
		MainClass.listCandies();
		log.info("\n");
		firstPage();
		log.info("\n");
	}
	
	public static void firstPage() {
			log.info("1. Search by name");
			log.info("2. Sort by");
			log.info("3. Buy chocolates");
			log.info("4. Exit\n");
			log.info("Enter choice:");
			int choice=sc.nextInt();
			switch (choice) {
				
				case 1:
					//MainClass.searchByName();
				case 2:
					//MainClass.sortBy();
				case 3:
					//MainClass.buyChocolates();
				case 4:
					log.info("Thanks for shopping !\nCome Back soon :) ");
				default:
					log.info("Enter valid input");
					firstPage();
			}
		}
	}

