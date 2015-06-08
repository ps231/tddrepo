package com.sorting;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSort2Test {

    // @Test
    // public void
    // firstIterationShouldReturnTheArrayAsIsSinceFirstElementIsAlwaysSorted() {
    // final int[] arrayAfterFirstIteration =
    // InsertionSort2.insertionSortPart2(new int[] { 2, 4, 6, 8, 3 });
    // Assert.assertArrayEquals(new int[] { 2, 4, 6, 8, 3 },
    // arrayAfterFirstIteration);
    // }

    // @Test
    // public void secondIterationShouldReturnTheSortedArrayForTwoElements() {
    // final int[] arrayAfterFirstIteration =
    // InsertionSort2.insertionSortPart2(new int[] { 2, 1, 6, 8, 3 });
    // Assert.assertArrayEquals(new int[] { 1, 2, 6, 8, 3 },
    // arrayAfterFirstIteration);
    // }

    @Test
    public void insertionSortShouldReturnTheSortedArray() {
        final int[] arrayAfterFirstIteration = InsertionSort2.insertionSortPart2(new int[] { 2, 4, 6, 8, 3 });
        Assert.assertArrayEquals(new int[] { 2, 3, 4, 6, 8 }, arrayAfterFirstIteration);
    }

    @Test
    public void insertionSortShouldReturnTheSortedArray1() {
        final int[] arrayAfterFirstIteration = InsertionSort2.insertionSortPart2(new int[] { 1, 4, 3, 5, 6, 2 });
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arrayAfterFirstIteration);
    }

    @Test
    public void insertionSortShouldReturnTheSortedArray2() {
        final int[] arrayAfterFirstIteration = InsertionSort2.insertionSortPart2(new int[] { -1, 4, -30, 50, 0, -2 });
        Assert.assertArrayEquals(new int[] { -30, -2, -1, 0, 4, 50 }, arrayAfterFirstIteration);
    }

}
