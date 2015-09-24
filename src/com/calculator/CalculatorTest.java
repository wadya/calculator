package com.calculator;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class CalculatorTest {

	@Test
	public void testDivide() throws Exception {

		double result = Calculator.divide(8.0, 2.0);
		assertThat(result, Is.is(4.0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDivideBy0() throws Exception {

		Calculator.divide(4.0, 0.0);
	}

	@Test
	public void testMultiply() throws Exception {

		double result = Calculator.multiply(4.0, 2.0);
		assertThat(result, Is.is(8.0));
	}

	@Test
	public void testAdd() throws Exception {

		Double result = Calculator.add(4.0, 2.0);
		assertThat(result, Is.is(6.0));
	}

	@Test
	public void testSubtract() throws Exception {

		double result = Calculator.subtract(4.0, 2.0);
		assertThat(result, Is.is(2.0));
	}
}