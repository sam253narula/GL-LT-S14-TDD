package com.greatlearning;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

//If you import the org.junit.Test class,your Test Suite Test class will not run as expected  it will not show exact which test cases it executed
import com.greatlearning.Calculator;

@RunWith(JUnitPlatform.class)
public class CalculatorTest {

	private Calculator calculator = new Calculator();
	
	@Test
	@DisplayName("shouldAddTwoNumbers inside CalculatorTest inside com.greatlearning package")
	public void shouldAddTwoNumbers() {
		int result = calculator.add(10, 5);
		Assert.assertEquals(15, result);
	}
	
}
