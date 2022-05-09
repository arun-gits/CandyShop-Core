package com.candyshop.junittest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.candyshop.logic.OverallValidation;

public class CandyTesting {
	public static int validName(String name) {
		if(name.isBlank()||name.isEmpty()) {
			return 1;
		}
		return 0;
	}
	@Test
	public void testName() {
		assertEquals(0,OverallValidation.validateName("Arun"));
	}
	@Test
	public void testName2() {
		assertEquals(1,OverallValidation.validateName("       "));
	}
	
	
}
