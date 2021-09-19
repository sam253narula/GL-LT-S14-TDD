package com.includemeseperatly;

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
	@DisplayName("shouldMultiplyTwoNumbers inside CalculatorTest inside com.includeMeSeperatly package")
	public void shouldMultiplyTwoNumbers() {
		int result = calculator.multiple(10, 5);
		Assert.assertEquals(50, result);
	}
	
}
