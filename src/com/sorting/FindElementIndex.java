package com.sorting;

public class FindElementIndex {

    private final int[] sortedArray;

    public FindElementIndex(final int[] inputArr) {
        validateInputArray(inputArr);
        this.sortedArray = inputArr;
    }

    private void validateInputArray(final int[] inputArr) {
        if (inputArr.length < 1 || inputArr.length > 1000) {
            throw new IllegalArgumentException("invalid input array");
        }
        validateArrayElements(inputArr);
    }

    private void validateArrayElements(final int[] inputArr) {
        for (final int elem : inputArr) {
            isElementValid(elem);
        }
    }

    public int getIndexOfElement(final int element) {
        int index = 0;
        for (; index < sortedArray.length; index++) {
            if (sortedArray[index] == element) {
                return index;
            }
        }
        return -1;
    }

    private boolean isElementValid(final int element) {
        if (element >= -1000 && element <= 1000) {
            return true;
        }
        throw new IllegalArgumentException("array element is invalid");
    }

}
