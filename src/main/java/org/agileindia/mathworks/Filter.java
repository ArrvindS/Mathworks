package org.agileindia.mathworks;

import java.util.ArrayList;
import java.util.List;

import org.agileindia.mathworks.conditions.Condition;

public class Filter {
	public static List<Integer> select(List<Integer> numbers, Condition condition) {
		List<Integer> selected = new ArrayList<>();
        for (Integer number : numbers) {
            if (condition.matches(number)) {
                selected.add(number);
            }
        }
        return selected;
	}
}