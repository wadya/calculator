package com.calculator;


/**
 * Created by Vadym Polishchuk on 9/24/15.
 * wadyasha@gmail.com
 */
public class Operation {

	private String action;
	private Double value;

	public Operation(String action, String value) {
		this.action = action;
		this.value = Double.parseDouble(value);
	}

	public String getAction() {
		return action;
	}

	public Double getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Operation operation = (Operation) o;

		if (!action.equals(operation.action)) return false;
		return value.equals(operation.value);

	}

	@Override
	public int hashCode() {
		int result = action.hashCode();
		result = 31 * result + value.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Operation{" +
				"action='" + action + '\'' +
				", value=" + value +
				'}';
	}
}
