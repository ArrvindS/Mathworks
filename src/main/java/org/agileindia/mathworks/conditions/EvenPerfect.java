package org.agileindia.mathworks.conditions;

import java.util.ArrayList;
import java.util.List;

public class EvenPerfect implements Condition {
    @Override
    public boolean matches(int number) {
        return EVEN.matches(number) && PERFECT.matches(number);
    }
}



