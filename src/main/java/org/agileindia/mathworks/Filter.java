package org.agileindia.mathworks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
    public static List<Integer> add(List<Integer> numbers){
        int sum = 0;
        List<Integer> selected = new ArrayList<>();
        for(Integer number : numbers) {
            sum += number;
        }
        selected.add(sum);
        return selected;
    }
    private static boolean range(int number, int low, int high){
        return (low <= number && number <= high);
    }
    public static List<Integer> range(List<Integer> numbers,int low , int high){
        List<Integer> selected = new ArrayList<>();
        for (Integer number : numbers) {
            if (range(number,low,high)) {
                selected.add(number);
            }
        }
        return selected;
    }


}