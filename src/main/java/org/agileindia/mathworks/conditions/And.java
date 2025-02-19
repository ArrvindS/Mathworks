package org.agileindia.mathworks.conditions;

public class And implements  Condition{
    private final Condition[] conditions;

    public And(Condition ...conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean matches(int number) {
        boolean result = true;
        for (Condition condition : conditions) {
            result &= condition.matches(number);
        }
        return result;
    }
}
