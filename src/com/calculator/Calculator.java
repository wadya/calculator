package com.calculator;

/**
 * Created by Vadym Polishchuk on 9/24/15.
 * wadyasha@gmail.com
 */
public class Calculator {

	/**
	 * Method divide two numbers
	 *
	 * @param a
	 * @param b
	 * @return
	 * @should divide a between b
	 */
	static Double divide(Double a, Double b) {

		if (b == 0) {

			throw new IllegalArgumentException();
		}

		return a / b;
	}

	/**
	 * Method multiply two numbers
	 *
	 * @param a
	 * @param b
	 * @return
	 * @should multiply a on b
	 */
	static Double multiply(Double a, Double b) {

		return a * b;
	}

	/**
	 * Method add two numbers
	 *
	 * @param a
	 * @param b
	 * @return
	 * @should add a to b
	 */
	static Double add(Double a, Double b) {

		return a + b;
	}

	/**
	 * Method subtract one from two numbers
	 *
	 * @param a
	 * @param b
	 * @return
	 * @should subtract a to b
	 */
	static Double subtract(Double a, Double b) {

		return a - b;
	}
}