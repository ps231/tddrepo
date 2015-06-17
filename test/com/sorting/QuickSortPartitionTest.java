package com.sorting;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortPartitionTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInputArrayLengthIsLessThan1() {
        final int[] ar = new int[0];
        QuickSortPartition.partition(ar);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInputArrayLengthIsGreaterThan1000() {
        final int[] ar = new int[1001];
        QuickSortPartition.partition(ar);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenArrayElementsAreInvalid() {
        QuickSortPartition.partition(new int[] { -1000, 1000, 1001 });
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenArrayElementsAreInvalid1() {
        QuickSortPartition.partition(new int[] { -1000, 1000, 0, -1, -1001 });
    }

    // @Test
    // public void shouldGetThePivotElementFromInputArray() {
    // Assert.assertEquals(-1000, QuickSortPartition.getPivotElement(new int[] {
    // -1000, 1000, 0, -1, -10 }));
    // }
    //
    // @Test
    // public void shouldGetArrayOfElementsLesserThanPivot() {
    // Assert.assertArrayEquals(new int[] { 3, 2 },
    // QuickSortPartition.getLesserElements(new int[] { 4, 5, 3, 7, 2 }, 4));
    // }
    //
    // @Test
    // public void shouldGetArrayOfElementsGreaterThanPivot() {
    // Assert.assertArrayEquals(new int[] { 5, 7 },
    // QuickSortPartition.getGreaterElements(new int[] { 4, 5, 3, 7, 2 }, 4));
    // }

    @Test
    public void shouldGetArrayOfElementsWithPivotInsertedCorrectly() {
        Assert.assertArrayEquals(new int[] { 3, 2, 4, 5, 7 }, QuickSortPartition.partition(new int[] { 4, 5, 3, 7, 2 }));
    }

    @Test
    public void shouldGetArrayOfElementsWithPivotInsertedCorrectly1() {
        Assert.assertArrayEquals(new int[] { 3, 2, 1, 0, 4 }, QuickSortPartition.partition(new int[] { 4, 3, 2, 1, 0 }));
    }

    @Test
    public void shouldGetArrayOfElementsWithPivotInsertedCorrectly2() {
        Assert.assertArrayEquals(new int[] { 4, 5, 6, 7, 8 }, QuickSortPartition.partition(new int[] { 4, 5, 6, 7, 8 }));
    }

    @Test
    public void shouldGetArrayOfElementsWithPivotInsertedCorrectly3() {
        Assert.assertArrayEquals(new int[] { 3, 1, 4, -10, 4, 5 }, QuickSortPartition.partition(new int[] { 4, 5, 3, 1, 4, -10 }));
    }

}
