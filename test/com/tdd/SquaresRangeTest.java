package com.tdd;

import org.junit.Assert;
import org.junit.Test;

//Watson gives two integers A & B to Sherlock and asks if he can count the number of square integers between A and B (both inclusive).
//A square integer is an integer which is the square of any integer. For example, 1, 4, 9, 16 are some of the square integers as they are squares of 1, 2, 3, 4 respectively.
//sample input
//3 9
//17 24
//sample output
//2
//0
//Test Case #00: In range [3,9], 4 and 9 are the two square numbers.
//Test Case #01: In range [17,24], there are no square numbers.
public class SquaresRangeTest {

    @Test(expected = IllegalArgumentException.class)
    public void invalidRangeLowerBoundMustThrowException() {
        SquareRange.getCountOfSquareIntegersWithin(0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidRangeUpperBoundMustThrowException() {
        SquareRange.getCountOfSquareIntegersWithin(1, 10000000001L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenLowerBoundIsGreaterThanUpperBound() {
        SquareRange.getCountOfSquareIntegersWithin(12, 5);
    }

    @Test
    public void shouldReturnNoOfSquareIntegersWithinGivenRange() {
        Assert.assertEquals(2, SquareRange.getCountOfSquareIntegersWithin(3, 9));
        Assert.assertEquals(0, SquareRange.getCountOfSquareIntegersWithin(17, 24));
        Assert.assertEquals(4, SquareRange.getCountOfSquareIntegersWithin(4, 30));
        Assert.assertEquals(4, SquareRange.getCountOfSquareIntegersWithin(4, 30));

    }

    @Test
    public void shouldReturnCorrectAnswerForInsaneRanges() {
        Assert.assertEquals(9855, SquareRange.getCountOfSquareIntegersWithin(465868129, 988379794));
        Assert.assertEquals(16518, SquareRange.getCountOfSquareIntegersWithin(150336667, 828238028));
        Assert.assertEquals(23201, SquareRange.getCountOfSquareIntegersWithin(55559381, 939697803));
    }

}
