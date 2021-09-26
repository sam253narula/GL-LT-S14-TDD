package com.greatlearning.testing.demo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

	private static Calculator calculator;
	
	@BeforeClass
	public static void setupBeforeAllTests() {
	 calculator = new Calculator();
		System.out.println("Executed only once before any test is exceuted");
	}
	
	@Before
	public void setup() {
		System.out.println("Executed before every Junit test");
	}
	
	@Test
	public void shouldAddtwoNumbers() {
		int result = calculator.add(10, 5);
		Assert.assertEquals(15, result);
	}

	@Test
	public void shouldSubtracttwoNumbers() {
		int result = calculator.subtract(10, 5);
		Assert.assertEquals(5, result);
	}

	@Test
	public void shouldMultiplyTwoNumbers() {
		int result = calculator.multiple(5, 10);
		Assert.assertEquals(50, result);
	}
	
	@After
	public void cleanup() {
		System.out.println("Executed after Every JUnit test");
	}
	
	@AfterClass
	public static void cleanupAfterAllExecution() {
		System.out.println("Executed  once after all test cases are executed");
	}
	
	
}
