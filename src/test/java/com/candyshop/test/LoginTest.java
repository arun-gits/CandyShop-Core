package com.candyshop.test;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.candyshop.logic.LoginValidation;


public class LoginTest {
	private static Logger log = LogManager.getLogger(LoginTest.class);

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		String message=null;
		
		log.info("Enter Email/Number:");
		String data = sc.next();
		log.info("Enter password:");
		String password = sc.next();
		
		LoginValidation test = new LoginValidation();
		
		message=test.loginCheck(data, password);
		log.info(message);
	
		sc.close();
	}
}
