package com.sorting;


public class BubbleSortShift {

    public static int calculateShifts(final int[] ar) {
        validate(ar);
        int totalShifts = 0;
        // for (int i = 0; i < 1; i++) {
        // for (int i = 0; i < 2; i++) {
        for (int i = 0; i < ar.length; i++) {
            totalShifts += iterateThroughElementsAndSwap(ar, ar.length - i);
        }
        return totalShifts;
    }

    private static int iterateThroughElementsAndSwap(final int[] ar, final int arrayIterationLimit) {
        int totalShifts = 0;
        for (int i = 0, j = 1; j < arrayIterationLimit; i++, j++) {
            if (ar[i] > ar[j]) {
                swapElements(ar, i, j);
                totalShifts++;
                // printArray(ar);
            }
        }
        return totalShifts;
    }

    private static void swapElements(final int[] ar, final int i, final int j) {
        final int temp = ar[j];
        ar[j] = ar[i];
        ar[i] = temp;
    }

    private static void validate(final int[] ar) {
        if (ar.length < 1 || ar.length > 1000) {
            throw new IllegalArgumentException("array length is invalid");
        }
        for (final int elem : ar) {
            validate(elem);
        }
    }

    private static void validate(final int elem) {
        if (elem < -10000 || elem > 10000) {
            throw new IllegalArgumentException("array elem is invalid");
        }
    }

    // private static void printArray(final int[] ar) {
    // for (final int n : ar) {
    // System.out.print(n + " ");
    // }
    // System.out.println("");
    // }

}
