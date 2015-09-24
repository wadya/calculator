package com.calculator;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vadym Polishchuk on 9/24/15.
 * wadyasha@gmail.com
 */
public class OperationTest {

	@Test
	public void testGetAction() throws Exception {

		Operation operation = new Operation("add", "2");
		assertThat(operation.getAction(), Is.is("add"));
	}

	@Test
	public void testGetValue() throws Exception {

		Operation operation = new Operation("add", "2");
		assertThat(operation.getValue(), Is.is(2.0));
	}

	@Test
	public void testEquals() throws Exception {

		Operation operation1 = new Operation("add", "2");
		Operation operation2 = new Operation("add", "2");
		assertEquals(operation1, operation2);
	}

	@Test
	public void Equals_Symmetric() throws Exception {

		Operation operation1 = new Operation("add", "2");
		Operation operation2 = new Operation("add", "2");
		assertTrue(operation1.equals(operation2) && operation2.equals(operation1));
		assertTrue(operation1.hashCode() == operation2.hashCode());

	}

	@Test
	public void testToString() throws Exception {

		Operation operation = new Operation("add", "2");
		String testString = "Operation{action='add', value=2.0}";
		assertEquals(operation.toString(), testString);
	}
}