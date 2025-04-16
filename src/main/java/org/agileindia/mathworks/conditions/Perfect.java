package org.agileindia.mathworks.conditions;

import java.util.ArrayList;
import java.util.List;

class Perfect implements Condition{

	public boolean matches(int number) {
        if (number <= 0)
            return false;

        int sumOfFactors = sum(factors(number));
        return sumOfFactors - number == number;
    }

	private static int sum(List<Integer> numbers) {
		int sum = 0;
		for (Integer number : numbers) {
			sum += number;
		}
		return sum;
	}

	private static List<Integer> factors(int number) {
		List<Integer> factors = new ArrayList<>();
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				factors.add(i);
			}
		}
		return factors;
	}

}
