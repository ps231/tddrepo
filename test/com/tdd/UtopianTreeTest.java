package com.tdd;

import org.junit.Assert;
import org.junit.Test;

//The Utopian tree goes through 2 cycles of growth every year. The first growth cycle occurs during
//the spring, when it doubles in height. The second growth cycle occurs during the summer, when its
//height increases by 1 meter. Now, a new Utopian tree sapling is planted at the onset of the spring. Its height is 1 meter.
//Can you find the height of the tree after N growth cycles?
//Constraints
//0 <= N <= 60
//Sample Input #00:
//2
//0
//1
//Sample Output #00:
//1
//2
//When N = 0, the height of the tree remains unchanged.
//When N= 1, the tree doubles its height as it's planted just before the onset of spring.

public class UtopianTreeTest {

    @Test
    public void shouldReturnDefaultHeightWhenGrowthCycleIs0() {
        Assert.assertEquals(1, new UtopianTree().findHeight(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenGrowthCycleIsLessThanLowerBound() {
        new UtopianTree().findHeight(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenGrowthCycleIsGreaterThanUpperBound() {
        new UtopianTree().findHeight(61);
    }

    @Test
    public void shouldReturnCalculatedHeightForGivenGrowthCycle() {
        Assert.assertEquals(2, new UtopianTree().findHeight(1));
        Assert.assertEquals(6, new UtopianTree().findHeight(3));
        Assert.assertEquals(7, new UtopianTree().findHeight(4));
    }

}
