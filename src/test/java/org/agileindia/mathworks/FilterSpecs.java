package org.agileindia.mathworks;

import static org.agileindia.mathworks.conditions.Condition.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;
import java.util.List;

import org.agileindia.mathworks.conditions.Condition;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;


public class FilterSpecs {
    @Test
    public void itSelectsPerfectNumbers() {
        //Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 10, 28);
		//When
        List<Integer> perfectNumbers = Filter.select(numbers, Condition.PERFECT);

        //Then
        assertThat(perfectNumbers, hasSize(2));
        assertThat(perfectNumbers, hasItems(6, 28));
    }

    @Test
    public void anyNegativeNumberOrZeroIsNotAPerfectNumber() {
        //Given
        List<Integer> numbers = Arrays.asList(-2, -1, 0, 6);
		//When
        List<Integer> primeNumbers = Filter.select(numbers, Condition.PERFECT);

        //Then
        assertThat(primeNumbers, hasSize(1));
        assertThat(primeNumbers, hasItem(6));
    }
    @Test
    public void itSelectsEvenNumber() {
    	List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		List<Integer> evenNumbers = Filter.select(numbers, Condition.EVEN);
    	
    	 assertThat(evenNumbers, hasItems(2, 4));
    	
    }
    @Test
    public void anyNegativeNumberOrZeroIsAEvenNumber() {
     
        List<Integer> numbers = Arrays.asList(1,2,-4);
		List<Integer> evenNumbers = Filter.select(numbers, Condition.EVEN);

        
        assertThat(evenNumbers, hasItems(2,-4));
    }
    @Test
    public void itSelectsOddPrime() {
    	List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		List<Integer> evenNumbers = Filter.select(numbers, or(Condition.ODD,Condition.PRIME));

        
        assertThat(evenNumbers, hasItems(3,5));
    }
    @Test
    public void itSelectsEvenPerfect() {
        List<Integer> numbers = Arrays.asList(1,2,3,6,8,27,28);
        List<Integer> evenPerfectNumbers = Filter.select(numbers, and(Condition.EVEN,Condition.PERFECT));
        assertThat(evenPerfectNumbers, hasSize(2));
        assertThat(evenPerfectNumbers, hasItems(6, 28));
    }
    @Test
    public void itSelectsEvenThatAreNotPerfect() {
        List<Integer> numbers = Arrays.asList(1,2,3,6,8,27,28);
        List<Integer> evenNotPerfectNumbers = Filter.select(numbers, and(Condition.EVEN,not(Condition.PERFECT)));
        assertThat(evenNotPerfectNumbers, hasItems(2));
    }

}
