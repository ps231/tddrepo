package com.tdd;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shindikp on 6/27/16.
 */
public class KangarooHoppingTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenKangarooPositionsOutOfRange() {
        KangarooHopping.willLandAtSameLocation(3, 3, 3, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenKangarooStartingPositionsInvalid() {
        KangarooHopping.willLandAtSameLocation(-1, 3, 10001, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenKangarooJumpRatesInvalid() {
        KangarooHopping.willLandAtSameLocation(3, 0, 4, 10001);
    }

    @Test
    public void shouldReturnFalseIfKangarooJumpRateIsSameOrLess() {
        Assert.assertFalse(KangarooHopping.willLandAtSameLocation(1, 1, 2, 1));
        Assert.assertFalse(KangarooHopping.willLandAtSameLocation(0, 2, 5, 3));
    }

    @Test
    public void shouldReturnTrueInCaseKangaroosCouldReachSameLocationAfterSameJumps() {
        Assert.assertTrue(KangarooHopping.willLandAtSameLocation(0, 3, 4, 2));
    }
}
