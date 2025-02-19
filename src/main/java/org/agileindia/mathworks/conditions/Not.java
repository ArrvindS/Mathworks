package org.agileindia.mathworks.conditions;

public class Not implements Condition {
    private final Condition condition;

    public Not(Condition left) {
        this.condition =left;

    }

    @Override
    public boolean matches(int number) {
        return !condition.matches(number);
    }
}
