package org.agileindia.mathworks.conditions;

public class OR implements Condition {
    private final Condition[] conditions;

    public OR(Condition... conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean matches(int number) {
        boolean result = true;
        for (Condition condition : conditions) {
            result = result || condition.matches(number);
        }
        return result;
    }
}
