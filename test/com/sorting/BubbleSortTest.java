package com.sorting;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfArraySizeIsLessThan1() {
        BubbleSort.sort(new int[] {});
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfArraySizeIsGreaterThan1000() {
        final int[] sortedArr = new int[1001];
        BubbleSort.sort(sortedArr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfArrayElementsAreOutOfRangeForUpperBound() {
        BubbleSort.sort(new int[] { -9999, 0, 10001 });
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfArrayElementsAreOutOfRangeForLowerBound() {
        BubbleSort.sort(new int[] { 0, 10001, -9999, -10000, -10001 });
    }

    // @Test
    // public void shouldReturnFirstIterationArrayCorrectly() {
    // final int[] sortedArray = BubbleSort.sort(new int[] { 3, 4, 2, 1 });
    // Assert.assertArrayEquals(new int[] { 3, 2, 1, 4 }, sortedArray);
    //
    // }

    // @Test
    // public void shouldReturnSecondIterationArrayCorrectly() {
    // final int[] sortedSecondIterationArray = BubbleSort.sort(new int[] { 3,
    // 4, 2, 1 });
    // Assert.assertArrayEquals(new int[] { 2, 1, 3, 4 },
    // sortedSecondIterationArray);
    //
    // }

    @Test
    public void shouldReturnSortedArrayCorrectly() {
        final int[] sortedArray = BubbleSort.sort(new int[] { 3, 4, 2, 1 });
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4 }, sortedArray);
    }

    @Test
    public void shouldReturnSortedArrayCorrectly1() {
        final int[] sortedArray = BubbleSort.sort(new int[] { 2, 4, 6, 8, 3 });
        Assert.assertArrayEquals(new int[] { 2, 3, 4, 6, 8 }, sortedArray);
    }

    @Test
    public void shouldReturnSortedArrayCorrectly2() {
        final int[] sortedArray = BubbleSort.sort(new int[] { 1, 4, 3, 5, 6, 2 });
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, sortedArray);
    }

    @Test
    public void shouldReturnSortedArrayCorrectly3() {
        final int[] sortedArray = BubbleSort.sort(new int[] { -1, 4, -30, 50, 0, -2 });
        Assert.assertArrayEquals(new int[] { -30, -2, -1, 0, 4, 50 }, sortedArray);
    }
}
