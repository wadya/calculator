package com.calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadym Polishchuk on 9/24/15.
 * wadyasha@gmail.com
 */
public class Main {

	public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

		List<Operation> operations = readFromFile(args[0]);

		System.out.println(calculate(operations));
	}

	/**
	 * Method read data by line from file and fill List with Operation objects
	 * @param fileName name of file
	 * @return list of Operation objects
	 * @throws IOException
	 * @see Operation
	 */
	public static List<Operation> readFromFile(String fileName) throws IOException {

		if (fileName == null || fileName.length() == 0) {

			throw new IllegalArgumentException("Running script without input filename as parameter not allowed!");
		}

		String file = "src/com/calculator/" + fileName;

		BufferedReader br = null;

		List<Operation> operations = new ArrayList<Operation>();

		try {

			FileReader fileReader = new FileReader(file);

			br = new BufferedReader(fileReader);

			for (String line; (line = br.readLine()) != null; ) {

				String[] split = line.split("\\s+");

				if (split.length > 1) {

					operations.add(new Operation(split[0], split[1]));
				}

			}
		} finally {

			if (br != null) {

				br.close();
			}
		}

		return operations;
	}

	/**
	 * Method get each object from list of Operation objects and call callCalculationMethod
	 * and return result of all operations
	 * @param operations list of Operations objects
	 * @return Double result
	 * @see Operation
	 */
	public static Double calculate(List<Operation> operations) {

		Double result;

		if (operations == null || operations.size() == 0) {

			throw new IllegalArgumentException("Input file is empty or contain incorrect data!");
		}

		Operation lastElement = operations.get(operations.size() - 1);

		if (!lastElement.getAction().equals("apply")) {

			throw new IllegalArgumentException("Last line must contain apply action!");
		}

		result = lastElement.getValue();

		operations.remove(lastElement);

		for (Operation operation : operations) {

			try {

				result = callCalculationMethod(result, operation);
			} catch (NoSuchMethodException e) {

				e.printStackTrace();
			} catch (InvocationTargetException e) {

				e.printStackTrace();
			} catch (IllegalAccessException e) {

				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * Method call methods from Calculator class using variable operation.getAction()
	 * as method name from Operation object
	 * @param result Double input result
	 * @param operation Operation object
	 * @return result of math operation on input result and
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @see Operation
	 * @see Calculator
	 */
	public static Double callCalculationMethod(Double result, Operation operation) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		Method method = Calculator.class.getDeclaredMethod(operation.getAction(), Double.class, Double.class);
		return (Double) method.invoke(null, result, operation.getValue());
	}
}
