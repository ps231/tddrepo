package com.sorting;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSort1Test {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfArraySizeIsLessThan1() {
        InsertionSort1.insertIntoSorted(new int[] {});
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfArraySizeIsGreaterThan1000() {
        final int[] sortedArr = new int[1001];
        InsertionSort1.insertIntoSorted(sortedArr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfArrayElementsAreOutOfRangeForUpperBound() {
        InsertionSort1.insertIntoSorted(new int[] { -9999, 0, 10001 });
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfArrayElementsAreOutOfRangeForLowerBound() {
        InsertionSort1.insertIntoSorted(new int[] { 0, 10001, -9999, -10000, -10001 });
    }

    //    @Test
    //    public void shouldReturnArrayAfterFirstIteration() {
    //        final int[] arrayAfterFirstIteration = InsertionSort1.insertIntoSorted(new int[] { 2, 4, 6, 8, 3 });
    //        Assert.assertArrayEquals(new int[] { 2, 4, 6, 8, 8 }, arrayAfterFirstIteration);
    //    }

    @Test
    public void shouldReturnSortedArrayWithElementCorrectlyInserted() {
        final int[] arrayAfterInsertion = InsertionSort1.insertIntoSorted(new int[] { 2, 4, 6, 8, 3 });
        Assert.assertArrayEquals(new int[] { 2, 3, 4, 6, 8 }, arrayAfterInsertion);

    }

    @Test
    public void shouldReturnSortedArrayWithElementCorrectlyInserted1() {
        final int[] arrayAfterInsertion = InsertionSort1.insertIntoSorted(new int[] { 2, 4, 6, 8, -10 });
        Assert.assertArrayEquals(new int[] { -10, 2, 4, 6, 8 }, arrayAfterInsertion);
    }

    @Test
    public void shouldReturnSortedArrayWithElementCorrectlyInserted2() {
        final int[] arrayAfterInsertion = InsertionSort1.insertIntoSorted(new int[] { 2, 4, 6, 8, 15 });
        Assert.assertArrayEquals(new int[] { 2, 4, 6, 8, 15 }, arrayAfterInsertion);
    }
}
