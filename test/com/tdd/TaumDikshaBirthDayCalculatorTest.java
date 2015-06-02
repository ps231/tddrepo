package com.tdd;

import org.junit.Assert;
import org.junit.Test;

public class TaumDikshaBirthDayCalculatorTest {

    private static final int LOWER_THAN_LOWER_BOUND = -1;
    private static final long HIGHER_THAN_UPPER_BOUND = 10000000001L;

    @Test
    public void birthdayCalculatorShouldExist() {
        Assert.assertNotNull(new BirthdayCalculator(10, 10, 1, 1, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForLowerBoundOnNoOfBlackGifts() {
        new BirthdayCalculator(LOWER_THAN_LOWER_BOUND, 10, 1, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForUpperBoundOnNoOfBlackGifts() {
        new BirthdayCalculator(HIGHER_THAN_UPPER_BOUND, 10, 1, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForLowerBoundOnNoOfWhiteGifts() {
        new BirthdayCalculator(10, LOWER_THAN_LOWER_BOUND, 1, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForUpperBoundOnNoOfWhiteGifts() {
        new BirthdayCalculator(10, 10000000001L, 1, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForLowerBoundOnPricePerBlackGifts() {
        new BirthdayCalculator(10, 10, LOWER_THAN_LOWER_BOUND, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForUpperBoundOnPricePerBlackGifts() {
        new BirthdayCalculator(10, 10, 10000000001L, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForLowerBoundOnPricePerWhiteGifts() {
        new BirthdayCalculator(10, 10, 1, LOWER_THAN_LOWER_BOUND, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForUpperBoundOnPricePerWhiteGifts() {
        new BirthdayCalculator(10, 10, 1, 10000000001L, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForLowerBoundOnPriceOfConversion() {
        new BirthdayCalculator(10, 10, 1, 1, LOWER_THAN_LOWER_BOUND);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForUpperBoundOnPriceOfConversion() {
        new BirthdayCalculator(10, 10, 1, 1, 10000000001L);
    }

    @Test
    public void shouldReturnMinAmountToBeSpentToPurchaseAllBlackAndWhiteGifts() {
        final BirthdayCalculator bc = new BirthdayCalculator(10, 10, 1, 1, 1);
        Assert.assertEquals(20, bc.deduceMinAmountToBeSpent());
    }

    @Test
    public void testCase2() {
        final BirthdayCalculator bc = new BirthdayCalculator(10, 10, 3, 1, 1);
        Assert.assertEquals(30, bc.deduceMinAmountToBeSpent());
    }

    @Test
    public void testCase3() {
        final BirthdayCalculator bc = new BirthdayCalculator(10, 10, 3, 2, 1);
        Assert.assertEquals(50, bc.deduceMinAmountToBeSpent());
    }

    @Test
    public void testCase4() {
        final BirthdayCalculator bc = new BirthdayCalculator(5, 9, 2, 3, 4);
        Assert.assertEquals(37, bc.deduceMinAmountToBeSpent());
    }

    @Test
    public void testCase5() {
        final BirthdayCalculator bc = new BirthdayCalculator(3, 6, 9, 1, 1);
        Assert.assertEquals(12, bc.deduceMinAmountToBeSpent());
    }

    @Test
    public void testCase6() {
        final BirthdayCalculator bc = new BirthdayCalculator(7, 7, 4, 2, 1);
        Assert.assertEquals(35, bc.deduceMinAmountToBeSpent());
    }

    @Test
    public void testCase7() {
        final BirthdayCalculator bc = new BirthdayCalculator(3, 3, 1, 9, 2);
        Assert.assertEquals(12, bc.deduceMinAmountToBeSpent());
    }

    @Test
    public void testCase8() {
        final BirthdayCalculator bc = new BirthdayCalculator(83666934, 10563001, 961640, 539051, 424245);
        Assert.assertEquals(86151466663811L, bc.deduceMinAmountToBeSpent());
    }

    @Test
    public void testCase9() {
        final BirthdayCalculator bc = new BirthdayCalculator(58987449, 22313527, 461810, 182410, 378447);
        Assert.assertEquals(31311204282760L, bc.deduceMinAmountToBeSpent());
    }
}
