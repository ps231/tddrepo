package com.sorting;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void mergeSortShouldReturnTheSortedArray() {
        final int[] sortedArray = MergeSort.sort(new int[] { 2 });
        Assert.assertArrayEquals(new int[] { 2 }, sortedArray);
    }

    @Test
    public void mergeSortShouldReturnTheSortedArray1() {
        final int[] sortedArray = MergeSort.sort(new int[] { 2, 1 });
        Assert.assertArrayEquals(new int[] { 1, 2 }, sortedArray);
    }

    @Test
    public void mergeSortShouldReturnTheSortedArray2() {
        final int[] sortedArray = MergeSort.sort(new int[] { 2, 3, 1 });
        Assert.assertArrayEquals(new int[] { 1, 2, 3 }, sortedArray);
    }

    @Test
    public void mergeSortShouldReturnTheSortedArray3() {
        final int[] sortedArray = MergeSort.sort(new int[] { 15, 6, 2, 14, 8, 7, 3, 1, 25 });
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 6, 7, 8, 14, 15, 25 }, sortedArray);
    }

    @Test
    public void mergeSortShouldReturnTheSortedArray4() {
        final int[] sortedArray = MergeSort.sort(new int[] { 15, 6, 2, 14, 8, 7, 3, 1, 25, 6, 3 });
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 3, 6, 6, 7, 8, 14, 15, 25 }, sortedArray);
    }

    @Test
    public void mergeSortShouldReturnTheSortedArray5() {
        final int[] sortedArray = MergeSort.sort(new int[] { 5, 4, 3, 2, 1, -4, -8, -15, 24, 17 });
        Assert.assertArrayEquals(new int[] { -15, -8, -4, 1, 2, 3, 4, 5, 17, 24 }, sortedArray);
    }

    @Test
    public void shouldMergeLeftAndRightSortedArrays() {
        final int[] mergedArray = MergeSort.mergeLeftAndRightSortedArrays(new int[] { 2 }, new int[] { 1, 3 });
        Assert.assertArrayEquals(new int[] { 1, 2, 3 }, mergedArray);
    }

    @Test
    public void shouldMergeLeftAndRightSortedArrays1() {
        final int[] mergedArray = MergeSort.mergeLeftAndRightSortedArrays(new int[] { 2, 7, 15 }, new int[] { 1, 3, 5, 8, 16 });
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 5, 7, 8, 15, 16 }, mergedArray);
    }

    @Test
    public void shouldMergeLeftAndRightSortedArrays2() {
        final int[] mergedArray = MergeSort.mergeLeftAndRightSortedArrays(new int[] { 2, 7, 15 }, new int[] { 1, 8 });
        Assert.assertArrayEquals(new int[] { 1, 2, 7, 8, 15 }, mergedArray);
    }

    @Test
    public void shouldMergeLeftAndRightSortedArrays3() {
        final int[] mergedArray = MergeSort.mergeLeftAndRightSortedArrays(new int[] { 3, 8 }, new int[] { 2, 7 });
        Assert.assertArrayEquals(new int[] { 2, 3, 7, 8 }, mergedArray);
    }
}
