package com.calculator;

import org.junit.Test;

/**
 * Created by Vadym Polishchuk on 9/24/15.
 * wadyasha@gmail.com
 */
public class MainTest {

	@Test(expected = IllegalArgumentException.class)
	public void testReadFromFileWithWrongName() throws Exception {

		Main.readFromFile("");
	}

	@Test
	public void testReadFromFile() throws Exception {

		Main.readFromFile("normalFile.txt");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculateWithLastNotApply() throws Exception {

		Main.calculate(Main.readFromFile("lastNotApply.txt"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculateWithoutCorrectData() throws Exception {

		Main.calculate(null);
	}

	@Test(expected = NoSuchMethodException.class)
	public void testCalculateWrongAction() throws Exception {

		Main.callCalculationMethod(3.0, new Operation("dadd","5"));
	}

	@Test
	public void testCalculateNormalData() throws Exception {

		Main.calculate(Main.readFromFile("normalFile.txt"));
	}
}