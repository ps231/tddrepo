package com.sorting;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortShiftTest {

    //    @Test
    //    public void shouldReturnFirstIterationArrayCorrectly() {
    //        final int totalShifts = BubbleSortShift.calculateShifts(new int[] { 3, 4, 2, 1 });
    //        Assert.assertEquals(2, totalShifts);
    //
    //    }

    @Test
    public void shouldReturnSortedArrayCorrectly() {
        final int totalShifts = BubbleSortShift.calculateShifts(new int[] { 3, 4, 2, 1 });
        Assert.assertEquals(5, totalShifts);

    }

    @Test
    public void shouldReturnSortedArrayCorrectly1() {
        final int totalShifts = BubbleSortShift.calculateShifts(new int[] { 2, 4, 6, 8, 3 });
        Assert.assertEquals(3, totalShifts);

    }

    @Test
    public void shouldReturnSortedArrayCorrectly2() {
        final int totalShifts = BubbleSortShift.calculateShifts(new int[] { 1, 4, 3, 5, 6, 2 });
        Assert.assertEquals(5, totalShifts);

    }

    @Test
    public void shouldReturnSortedArrayCorrectly3() {
        final int totalShifts = BubbleSortShift.calculateShifts(new int[] { -1, 4, -30, 50, 0, -2 });
        Assert.assertEquals(8, totalShifts);

    }

}