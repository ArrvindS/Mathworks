package org.agileindia.mathworks.conditions;

public class OddCondition implements Condition {
    @Override
    public boolean matches(int number) {
        return !(number % 2 == 0);
    }
}
