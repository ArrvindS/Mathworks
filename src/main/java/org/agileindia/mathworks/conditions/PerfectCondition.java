package org.agileindia.mathworks.conditions;

import java.util.ArrayList;
import java.util.List;

class PerfectCondition implements Condition{

	public boolean matches(int number) {
	    if (number > 0) {
	        List<Integer> factors = new ArrayList<>();
	        for (int i = 1; i <= number; i++) {
	            if (number % i == 0) {
	                factors.add(i);
	            }
	        }
	        int sumOfFactors = 0;
	        for (Integer i : factors) {
	            sumOfFactors += i;
	        }
	        return sumOfFactors - number == number;
	    }
	    return false;
	}

}
