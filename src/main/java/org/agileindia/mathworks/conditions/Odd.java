package org.agileindia.mathworks.conditions;

public class Odd implements Condition {
    @Override
    public boolean matches(int number) {
        return !(number % 2 == 0);
    }
}
