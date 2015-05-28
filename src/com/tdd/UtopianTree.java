package com.tdd;

public class UtopianTree {

    private int height = 1;

    public int findHeight(final int growthCycle) {
        validateGrowthCycle(growthCycle);
        if (growthCycle == 0) {
            return height;
        } else {
            for (int i = 1; i <= growthCycle; i++) {
                if (isSummer(i)) {
                    height += 1;
                } else {
                    height *= 2;
                }
            }
            return height;
        }
    }

    private boolean isSummer(int i) {
        return i % 2 == 0;
    }

    private void validateGrowthCycle(final int growthCycle) {
        if (growthCycle < 0 || growthCycle > 60)
            throw new IllegalArgumentException("invalid growth cycle");
    }

}
