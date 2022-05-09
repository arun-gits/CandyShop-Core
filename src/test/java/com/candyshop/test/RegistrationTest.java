package com.candyshop.test;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.candyshop.dao.UserDAO;
import com.candyshop.logic.RegistrationValidation;
import com.candyshop.model.User;

public class RegistrationTest {
	private static Logger log=LogManager.getLogger(RegistrationTest.class);

	static Scanner sc=new Scanner(System.in);
	static Scanner dc=new Scanner(System.in);
	public static void main(String[] args) {
		int testName=0;
		int testNumber=0;
		int testMail=0;
		int testPassword=0;
		
		log.info("Enter your name:");
		String name=sc.next();
		log.info("Enter you mobile:");
		String mobile=sc.next();
		log.info("Enter your email:");
		String mail=sc.next();
		log.info("Enter your address:");
		String address=dc.nextLine();
		log.info("Enter your password");
		String password=sc.next();
		User user=new User();
		user.setName(name);
		user.setMobile(mobile);
		user.setEmail(mail);
		user.setAddress(address);
		user.setPassword(password);
		RegistrationValidation test=new RegistrationValidation();
		UserDAO check=new UserDAO();
		try {
			testName=test.validateName(user.getName());
			testNumber=test.validateMobile(user.getMobile());
			testMail=test.validateEmail(user.getEmail());
			testPassword=test.validatePassword(user.getPassword());
		}
		catch(Exception e){
			log.warn(e.getMessage());
			//e.printStackTrace();
		}
		if(testName+testNumber+testMail+testPassword==4) {
			log.info("Validation Passed");
			try {
				check.signUpMailValidation(mail);
				check.signUpNumberValidation(mobile);
				log.info("Validation using Database passed");
				check.addUser(user);
			}
			catch(Exception e) {
				
				log.warn(e.getMessage());
				//e.printStackTrace();
			}
		}
		
//		else {
//			System.exit(0);
//		}
		sc.close();
	}
}
