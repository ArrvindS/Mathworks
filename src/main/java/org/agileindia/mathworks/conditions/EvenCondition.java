	package org.agileindia.mathworks.conditions;

class EvenCondition implements Condition {

	@Override
	public boolean matches(int number) {

		return (number % 2 == 0);
	}

}
