package com.tdd;

import org.junit.Assert;
import org.junit.Test;

//Find whether a given number exists in the Fibonacci series. Restrict the series to 50 numbers.

public class FibonacciTest {

    // 0 1 1 2 3 5...
    @Test
    public void shouldReturnTrueFor0And1() {
        Assert.assertTrue(Fibonacci.numberExists(0));
        Assert.assertTrue(Fibonacci.numberExists(1));
    }

    @Test
    public void shouldReturnFalseForNegativeNumbers() {
        Assert.assertFalse(Fibonacci.numberExists(-1));
        Assert.assertFalse(Fibonacci.numberExists(-5));
    }

    @Test
    public void shouldReturnTrueForFibonacciSeriesNumbers() {
        Assert.assertTrue(Fibonacci.numberExists(2));
        Assert.assertTrue(Fibonacci.numberExists(3));
        Assert.assertTrue(Fibonacci.numberExists(5));
        Assert.assertTrue(Fibonacci.numberExists(8));
        Assert.assertTrue(Fibonacci.numberExists(13));
    }

    @Test
    public void shouldReturnFalseForNonFibonacciSeriesNumbers() {
        Assert.assertFalse(Fibonacci.numberExists(4));
        Assert.assertFalse(Fibonacci.numberExists(6));
        Assert.assertFalse(Fibonacci.numberExists(7));
        Assert.assertFalse(Fibonacci.numberExists(9));
        Assert.assertFalse(Fibonacci.numberExists(10));
    }


}
