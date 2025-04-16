	package org.agileindia.mathworks.conditions;

class Even implements Condition {

	@Override
	public boolean matches(int number) {

		return (number % 2 == 0);
	}

}
