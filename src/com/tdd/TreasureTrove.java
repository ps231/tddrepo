package com.tdd;

import java.util.HashSet;
import java.util.Set;

public class TreasureTrove {
    private final int noOfStones;
    private final int diff1;
    private final int diff2;

    public TreasureTrove(final int noOfStones, final int diff1, final int diff2) {
        validateArgs(noOfStones, diff1, diff2);
        this.noOfStones = noOfStones;
        this.diff1 = diff1;
        this.diff2 = diff2;
    }

    private void validateArgs(final int noOfStones, final int diff1, final int diff2) {
        if (noOfStones <= 0 || noOfStones > 15 || Math.abs(diff1 - diff2) > 5) {
            throw new IllegalArgumentException("illegal args");
        }
    }

    public Set<Integer> getLastStones() {
        final Set<Integer> lastStones = new HashSet<Integer>();
        if (noOfStones == 1) {
            lastStones.add(this.diff1);
            lastStones.add(this.diff2);
        }
        return lastStones;
    }

}
