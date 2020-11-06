package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {

	NumberWorker nw = new NumberWorker();

	@ParameterizedTest
	@ValueSource (ints = {7, 11, 113, 13})
	public void isPrimeForPrimes(int num) {
		boolean expected = true;
		boolean actual = nw.isPrime(num);
		Assertions.assertEquals(expected, actual);

	}

	@ParameterizedTest
	@ValueSource (ints = { 4, 33, 100})
	public void isPrimeForNotPrimes(int num) {
		boolean expected = false;
		boolean actual = nw.isPrime(num);
		Assertions.assertEquals(expected, actual);
	}


	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 1})
	public void isPrimeForIncorrectNumbers(int num) {
			try {
				nw.isPrime(num);
				Assertions.fail("Expected IllegalNumberException");
			} catch (IllegalNumberException e) {
				Assertions.assertEquals("number less or equals 1", e.getMessage());
			}
	}

	@ParameterizedTest
	@CsvFileSource (resources = "/data.csv")
	public void   CorrectDigitsSum(ArgumentsAccessor arguments) {
		int num = arguments.getInteger(0);
		int expected = arguments.getInteger(1);
		int actual = nw.digitsSum(num);
		Assertions.assertEquals(expected, actual);
	}

	@ParameterizedTest
	@CsvFileSource (resources = "/data_fails.csv")
	public void   NotCorrectDigitsSum(ArgumentsAccessor arguments) {
		int num = arguments.getInteger(0);
		int unexpected = arguments.getInteger(1);
		int actual = nw.digitsSum(num);
		Assertions.assertNotEquals(unexpected, actual);
	}


}
