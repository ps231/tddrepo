package com.sorting;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(final int[] inputArr) {
        return divideAndConquer(inputArr);
    }

    private static int[] divideAndConquer(final int[] inputArr) {
        if (inputArr.length == 1) {
            return inputArr;
        }

        /*
         * we don't need this condition to sort array with length 2, because the
         * merge functionality takes care of comparisons. even though we sort
         * arrays with length 2 here, merge will still need to compare. 
         * eg: [3, 8] and [2, 5]. merge will now need to compare 3 and 2 and arrange
         * them as 2, 3 in resulting array. We save an extra, unnecessary
         * comparison operation here.
         */
        // if (inputArr.length == 2) {
        // return sortedArray(inputArr);
        // }

        final int center = inputArr.length / 2;
        final int[] left = Arrays.copyOfRange(inputArr, 0, center);
        final int[] right = Arrays.copyOfRange(inputArr, center, inputArr.length);

        final int[] leftSorted = divideAndConquer(left);
        final int[] rightSorted = divideAndConquer(right);

        return mergeLeftAndRightSortedArrays(leftSorted, rightSorted);
    }

    protected static int[] mergeLeftAndRightSortedArrays(final int[] leftSorted, final int[] rightSorted) {
        final int[] mergedArray = new int[leftSorted.length + rightSorted.length];
        int leftCounter = 0, rightCounter = 0;
        for (int mergedCounter = 0; mergedCounter < mergedArray.length; mergedCounter++) {
            if (isEndOfArray(leftSorted, leftCounter)) {
                copyRemainingContentsOfOtherArray(mergedCounter, mergedArray, rightSorted, rightCounter);
                break;
            }
            if (isEndOfArray(rightSorted, rightCounter)) {
                copyRemainingContentsOfOtherArray(mergedCounter, mergedArray, leftSorted, leftCounter);
                break;
            }
            if (isLeftElementSmallerThanRightElement(leftSorted, rightSorted, leftCounter, rightCounter)) {
                leftCounter = copyElementToMergedArray(leftSorted, mergedArray, leftCounter, mergedCounter);
            } else {
                rightCounter = copyElementToMergedArray(rightSorted, mergedArray, rightCounter, mergedCounter);
            }
        }
        return mergedArray;
    }

    private static boolean isLeftElementSmallerThanRightElement(final int[] leftSorted, final int[] rightSorted, final int j, final int k) {
        return leftSorted[j] < rightSorted[k];
    }

    private static boolean isEndOfArray(final int[] sortedArray, final int index) {
        return index == sortedArray.length;
    }

    private static void copyRemainingContentsOfOtherArray(final int mergedArrayCounter, final int[] mergedArray, final int[] remainingSortedArray, int sortCounter) {
        for (int i = mergedArrayCounter; i < mergedArray.length; i++) {
            sortCounter = copyElementToMergedArray(remainingSortedArray, mergedArray, sortCounter, i);
        }
    }

    private static int copyElementToMergedArray(final int[] sorted, final int[] mergedArray, int sortedCounter, final int mergedArrayCounter) {
        mergedArray[mergedArrayCounter] = sorted[sortedCounter++];
        return sortedCounter;
    }

    // private static int[] sortedArray(final int[] inputArr) {
    // if (inputArr[0] > inputArr[1]) {
    // swap(inputArr);
    // }
    // return inputArr;
    // }
    //
    // private static void swap(final int[] inputArr) {
    // final int tmp = inputArr[0];
    // inputArr[0] = inputArr[1];
    // inputArr[1] = tmp;
    // }
}
