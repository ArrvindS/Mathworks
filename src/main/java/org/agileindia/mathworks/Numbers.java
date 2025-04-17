package org.agileindia.mathworks;

import java.util.ArrayList;
import java.util.List;

import org.agileindia.mathworks.conditions.Condition;

public class Numbers {

    private List<Integer> numbers = new ArrayList<>();

    public Numbers(int ...numbers) {
        this.numbers.addAll(toList(numbers));
    }

    public Numbers(List<Integer> numbers) {
        this.numbers.addAll(numbers);
    }

    public static List<Integer> select(List<Integer> numbers, Condition condition) {
		List<Integer> selected = new ArrayList<>();
        for (Integer number : numbers) {
            if (condition.matches(number)) {
                selected.add(number);
            }
        }
        return selected;
	}

    private static boolean inBetween(int number, int low, int high){

        return (low <= number && number <= high);
    }


    public Numbers select(Condition condition) {

        return new Numbers(select(numbers, condition));
    }

    public int size() {
        return numbers.size();
    }

    public boolean hasItems(int... items) {

        return numbers.containsAll(toList(items));
    }

    private List<Integer> toList(int[] items) {
        List<Integer> toVerify = new ArrayList<>();
        for (int number : items) {
            toVerify.add(number);
        }
        return toVerify;
    }

    public int sum() {
        int result = 0;
        for(Integer number : numbers) {
            result += number;
        }
        return result;
    }

    public Numbers inBetween(int low, int high) {
        List<Integer> selected = new ArrayList<>();
        for (Integer number : numbers) {
            if (inBetween(number, low, high)) {
                selected.add(number);
            }
        }
        return new Numbers(selected);
    }

    public int multiply() {
        int product = 1;
        for(Integer number : numbers) {
            product *= number;
        }
        return product;
    }

    public Numbers multiplyBy(int factor) {
        List<Integer> resultedList = new ArrayList<>();
        for (Integer number : numbers) {
                number *= factor;
                resultedList.add(number);

        }
        return new Numbers(resultedList);
    }

    public Numbers square() {
        List<Integer> squaredList=new ArrayList<>();

        for(Integer number : numbers){

            number *= number;
            squaredList.add(number);
        }
        return new Numbers(squaredList);
    }

    public int findFirstOccurance(int numberTobeFound) {

        for(Integer number : numbers){

            if(number == numberTobeFound)
                return numbers.indexOf(number) + 1;

        }
        return -1;

    }
}