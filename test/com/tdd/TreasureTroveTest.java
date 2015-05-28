package com.tdd;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class TreasureTroveTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInvalidNoOfStonesSpecified() {
        new TreasureTrove(16, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhen0StonesSpecified() {
        new TreasureTrove(0, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenDifferenceBetweenStonesIsGreaterThan5() {
        new TreasureTrove(15, 1, 7);
    }

    @Test
    public void shouldReturnGivenStonesWhenNoOfStonesIs1() {
        TreasureTrove tt = new TreasureTrove(1, 3, 5);
        Set<Integer> expectedlastStones = getExpectedLastStones(3, 5);
        Assert.assertEquals(expectedlastStones, tt.getLastStones());

        tt = new TreasureTrove(1, 2, 5);
        expectedlastStones = getExpectedLastStones(2, 5);
        Assert.assertEquals(expectedlastStones, tt.getLastStones());
    }

    private Set<Integer> getExpectedLastStones(final int... stones) {
        final Set<Integer> lastStones = new HashSet<Integer>();
        for (final int stone : stones) {
            lastStones.add(stone);
        }
        return lastStones;
    }

}
