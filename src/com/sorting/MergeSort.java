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

        if (inputArr.length == 2) {
            return sortedArray(inputArr);
        }

        final int center = inputArr.length / 2;
        final int[] left = Arrays.copyOfRange(inputArr, 0, center);
        final int[] right = Arrays.copyOfRange(inputArr, center, inputArr.length);

        final int[] leftSorted = divideAndConquer(left);
        final int[] rightSorted = divideAndConquer(right);

        return mergeLeftAndRightSortedArrays(leftSorted, rightSorted);
    }

    protected static int[] mergeLeftAndRightSortedArrays(final int[] leftSorted, final int[] rightSorted) {
        final int[] mergedArray = new int[leftSorted.length + rightSorted.length];
        int j = 0, k = 0;
        for (int i = 0; i < mergedArray.length; i++) {
            if (isArrayCopyComplete(leftSorted, j)) {
                copyRemainingArrayContents(i, mergedArray, rightSorted, k);
                break;
            }
            if (isArrayCopyComplete(rightSorted, k)) {
                copyRemainingArrayContents(i, mergedArray, leftSorted, j);
                break;
            }
            if (leftSorted[j] < rightSorted[k]) {
                mergedArray[i] = leftSorted[j++];
            } else {
                mergedArray[i] = rightSorted[k++];
            }
        }
        return mergedArray;
    }

    private static boolean isArrayCopyComplete(final int[] sortedArray, final int index) {
        return index == sortedArray.length;
    }

    private static void copyRemainingArrayContents(final int mergedArrayCounter, final int[] mergedArray, final int[] remainingSortedArray, int sortCounter) {
        for (int i = mergedArrayCounter; i < mergedArray.length; i++) {
            mergedArray[i] = remainingSortedArray[sortCounter++];
        }
    }

    private static int[] sortedArray(final int[] inputArr) {
        if (inputArr[0] > inputArr[1]) {
            swap(inputArr);
        }
        return inputArr;
    }

    private static void swap(final int[] inputArr) {
        final int tmp = inputArr[0];
        inputArr[0] = inputArr[1];
        inputArr[1] = tmp;
    }
}
