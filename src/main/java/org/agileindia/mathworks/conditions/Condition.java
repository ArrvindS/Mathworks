package org.agileindia.mathworks.conditions;

import java.util.function.Predicate;
import java.util.stream.IntStream;

@FunctionalInterface
public interface Condition {
	
	public static Condition EVEN = number -> number % 2 == 0;
	public static Condition PERFECT = (n -> n > 1 &&IntStream.range(1, n).filter(i -> n % i == 0).sum() == n);
	public static Condition ODD= Condition.not(EVEN);

	public static Condition PRIME=number -> {
		if (number <= 1) return false;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) return false;
		}
		return true;
	};

    // int -> bool
	boolean matches(int number);


	static Condition and(Condition... conditions) {
		return number -> {
			boolean result = true;
			for(Condition condition: conditions){
				result &= condition.matches(number);
			}
		return result;};
	}
	static Condition or(Condition... conditions) {
		return number -> {
			boolean result = true;
			for(Condition condition: conditions){
				result=result|| condition.matches(number);
			}
		return result;};
	}
	static Condition not(Condition func) {
		return number -> !func.matches(number);
	}


}
