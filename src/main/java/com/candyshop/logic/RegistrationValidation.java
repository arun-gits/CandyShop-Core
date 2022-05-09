package com.candyshop.logic;

public class RegistrationValidation {

	public int validateName(String name) throws Exception {

		if (name.isEmpty() || name.isBlank()) {
			throw new Exception("Invalid name");

		}
		return 1;
	}

	public int validateEmail(String mail) throws Exception {
		if (!mail.contains("@") || !mail.contains(".")) {
			throw new Exception("Invalid mail");

		} else {
			return 1;
		}
	}

	public int validateMobile(String mobile) throws Exception {
		if (mobile.length() != 10) {
			throw new Exception("Invalid number !!!");

		} else if (mobile.length() == 10) {
			for (int i = 0; i < mobile.length(); i++) {
				char ch = mobile.charAt(i);
				if (!Character.isDigit(ch)) {
					throw new Exception("Mobile number should not contain characters!");

				}
			}
		}
		return 1;
	}

	public int validatePassword(String password) throws Exception {

		if (password.isEmpty() || password.isBlank() || password.length() < 8 || password.length() > 16) {
			throw new Exception("Password should be minimum 8 characters and maximum 16 characters");

		}
		return 1;
	}

}
