package com.greatlearning;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		if (a > b) {
			return a - b;
		} else {
			return b - a;
		}
	}

	public int multiple(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		if (a != 0 && b != 0) {
			return a / b;
		} else {
			throw new ArithmeticException("cant divide any number by 0, java does suppport infinity answer");
		}
	}
}
