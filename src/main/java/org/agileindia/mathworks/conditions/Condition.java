package org.agileindia.mathworks.conditions;

public interface Condition {
	
	public static Condition EVEN = new EvenCondition();
	public static Condition PERFECT = new PerfectCondition();
	public static Condition ODD= new OddCondition();
	public static Condition PRIME=new PrimeCondition();

	boolean matches(int number);

	static Condition and(Condition... conditions) {
		return new And(conditions);
	}
	static Condition or(Condition... conditions) {
		return new OR(conditions);
	}
	static Condition not(Condition left) {
		return new Not(left);
	}
}
