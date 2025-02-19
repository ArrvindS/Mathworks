package org.agileindia.mathworks.conditions;

public class OddPrimes implements Condition {

	@Override
	public boolean matches(int number) {
        return ODD.matches(number) && PRIME.matches(number);
    }

}
