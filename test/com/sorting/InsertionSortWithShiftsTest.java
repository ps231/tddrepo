package com.sorting;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortWithShiftsTest {

    @Test
    public void insertionSortShouldReturnTheSortedArray() {
        Assert.assertEquals(6, InsertionSortWithShifts.calculateTotalShifts(new int[] { 2, 4, 6, 1, 8, 3 }));
    }

    @Test
    public void insertionSortShouldReturnTheSortedArray1() {
        Assert.assertEquals(5, InsertionSortWithShifts.calculateTotalShifts(new int[] { 3, 4, 2, 1 }));
    }

    @Test
    public void insertionSortShouldReturnTheSortedArray2() {
        Assert.assertEquals(8, InsertionSortWithShifts.calculateTotalShifts(new int[] { -1, 4, -30, 50, 0, -2 }));
    }

    @Test
    public void insertionSortShouldReturnTheSortedArray3() {
        Assert.assertEquals(4, InsertionSortWithShifts.calculateTotalShifts(new int[] { 2, 1, 3, 1, 2 }));
    }

    @Test
    public void insertionSortShouldReturnTheSortedArray4() {
        Assert.assertEquals(6, InsertionSortWithShifts.calculateTotalShifts(new int[] { 4, 3, 2, 1 }));
    }

    @Test
    public void insertionSortShouldReturnTheSortedArray5() {
        Assert.assertEquals(0, InsertionSortWithShifts.calculateTotalShifts(new int[] { 4, 5, 6, 7, 10 }));
    }

}
