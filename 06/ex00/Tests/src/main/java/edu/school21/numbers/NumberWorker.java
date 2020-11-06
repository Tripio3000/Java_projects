package edu.school21.numbers;

public class NumberWorker {

	public boolean isPrime(int number) {

		if (number <= 0 || number == 1) {
			throw new IllegalNumberException("number less or equals 1");
		}

		long longNum = number;

		boolean resultFlag = true;

		for (long i = 2; i * i <= longNum; i++) {

			if (longNum % i == 0) {
				resultFlag = false;
				break ;
			}
		}

		return resultFlag;
	}

	public int digitsSum(int number) {

		int digitsCalc = 1;

		int result = 0;

		int digitsCalcCalculator = number;


		if (number < 0) {
			number *= -1;
		}

		while (digitsCalcCalculator / 10 != 0) {
			digitsCalcCalculator /= 10;
			digitsCalc *= 10;
		}

		while (digitsCalc > 1) {
			result  += number / digitsCalc;
			number %= digitsCalc;
			digitsCalc /= 10;
		}

		result += number;

		return result;
	}
}
