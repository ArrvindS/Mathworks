package org.agileindia.mathworks;

import static org.agileindia.mathworks.conditions.Condition.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.agileindia.mathworks.conditions.Condition;
import org.junit.jupiter.api.Test;


public class NumbersSpecs {
    @Test
    public void itSelectsPerfectNumbers() {
        //Given
        Numbers numbers = new Numbers(1, 2, 3, 4, 5, 6, 10, 28);
		//When
        Numbers perfect = numbers.select(Condition.PERFECT);

        //Then
        assertThat(perfect.size(), equalTo(2));
        assertThat(perfect.hasItems(6, 28), is(true));
    }


    @Test
    public void anyNegativeNumberOrZeroIsNotAPerfectNumber() {
        //Given
        Numbers numbers = new Numbers(-2, -1, 0, 6);
		//When
        Numbers prime = numbers.select(Condition.PERFECT);

        //Then
        assertThat(prime.size(), equalTo(1));
        assertThat(prime.hasItems(6),is(true));
    }
    @Test
    public void itSelectsEvenNumber() {
        Numbers numbers = new Numbers(1, 2, 3, 4);
		Numbers even = numbers.select(Condition.EVEN);
    	
    	 assertThat(even.hasItems(2,4),is(true));
    	
    }

    @Test
    public void anyNegativeNumberOrZeroIsAEvenNumber() {

        Numbers numbers = new Numbers(1,2,-4);
		Numbers even = numbers.select(Condition.EVEN);

        
        assertThat(even.hasItems(2,-4),is(true));
    }
    @Test
    public void itSelectsOddOrPrime() {
    	Numbers numbers = new Numbers(1,2,3,4,5);
		Numbers oddAndPrime = numbers.select(or(Condition.ODD,Condition.PRIME));

        
        assertThat(oddAndPrime.hasItems(3,5),is(true));
    }

    @Test
    public void itSelectsEvenAndPerfect() {
        Numbers numbers = new Numbers(1,2,3,6,8,27,28);
        Numbers evenAndPerfect = numbers.select(and(Condition.EVEN,Condition.PERFECT));
        assertThat(evenAndPerfect.size(),equalTo(2));
        assertThat(evenAndPerfect.hasItems(6,28), is(true));
    }

    @Test
    public void itSelectsEvenThatAreNotPerfect() {
        Numbers numbers = new Numbers(1,2,3,6,8,27,28);
        Numbers evenNotPerfect = numbers.select(and(Condition.EVEN,not(Condition.PERFECT)));
        assertThat(evenNotPerfect.hasItems(2), is(true));
    }

    @Test
    public void toFindSumoftheNumbers() {

        Numbers numbers = new Numbers(5,7,10,5);

        int  sumOfNumbers = numbers.sum();

        assertThat(sumOfNumbers,equalTo(27));
    }
    @Test
    public void itSelectsNumbersWithinInBetween(){

        Numbers numbers = new Numbers(5,7,10,15);

        Numbers  numberWithinRange = numbers.inBetween(5,10);

        assertThat(numberWithinRange.hasItems(5,7,10),is(true));
    }
    @Test
    public void toLearnMultiplyOfNumbers(){

        Numbers numbers = new Numbers(5,7,10,5);

        int valueafterMultiplication = numbers.multiply();

        assertThat(valueafterMultiplication,equalTo(1750));
    }
    @Test
    public void toLearnMultiplyByForNumbers(){

        Numbers numbers = new Numbers(5,7,10,15);

        Numbers multipliedList = numbers.multiplyBy(10);

        assertThat(multipliedList.hasItems(50,70,100,150),is(true));
    }

}
