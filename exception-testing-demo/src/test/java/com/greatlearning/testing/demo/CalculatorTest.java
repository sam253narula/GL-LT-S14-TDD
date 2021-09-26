package com.greatlearning.testing.demo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class CalculatorTest {

	private static Calculator calculator;
	
	@BeforeClass
	public static void setupBeforeAllTests() {
	 calculator = new Calculator();
		System.out.println("Executed only once before any test is exceuted");
	}
	
	// Deprecated in the latest version of JUnit Library 4.13.2, since there is new way, which does not need this
//	@Rule
//	public ExpectedException thrown = ExpectedException.none();
	
	// Method 1 of testing exceptions, basic method of testing expected exceptions
//	@Test(expected = ArithmeticException.class)
//	public void shouldThrowArithmeticExceptionWhenDivideByZero() {
//		calculator.divide(10, 0);
//	}
	
	/* Method 2 of testing exceptions, below method is for deprecated @Rules way of Expected Exception
	 *  or Deprecated way for JUnit version 4.13.2 
	 */
	
//	@Test
//	public void shouldThrowArithmeticExceptionWhenDivideByZero() {
//		thrown.expect(ArithmeticException.class);
//		thrown.expectMessage("cant divide any number by 0, java does support infinity answer");
//		calculator.divide(10, 0);
//	}
	
	// Method 2 Way for Junit version 4.13.2 and above, now you don't need @Rule
	@Test
	public void shouldThrowArithmeticExceptionWhenDivideByZero() {
		ArithmeticException ex = Assert.assertThrows(ArithmeticException.class, () -> calculator.divide(0, 10));
		Assert.assertEquals("cant divide any number by 0, java does support infinity answer", ex.getMessage());
	}
	
}
