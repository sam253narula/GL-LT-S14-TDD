package com.greatlearning.subtract;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//If you import the org.junit.Test class,your Test Suite Test class will not run as expected  it will not show exact which test cases it executed
import com.greatlearning.Calculator;

public class CalculatorTest {

	private Calculator calculator = new Calculator();
	
	@Test
	@DisplayName("shouldSubtractTwoNumbers inside CalculatorTest inside com.greatlearning.subtract package")
	public void shouldSubtractTwoNumbers() {
		int result = calculator.subtract(10, 5);
		Assert.assertEquals(5, result);
	}
	
}
