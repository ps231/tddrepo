package com.sorting;

import java.util.Scanner;

public class BubbleSort {

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int s = in.nextInt();
        final int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        sort(ar);
        in.close();
    }

    public static int[] sort(final int[] ar) {
        validate(ar);
        int[] sortedArrayAfterIteration = null;
        // for (int i = 0; i < 1; i++) {
        // for (int i = 0; i < 2; i++) {
        for (int i = 0; i < ar.length; i++) {
            sortedArrayAfterIteration = iterateThroughElementsAndSwap(ar, ar.length - i);
        }
        return sortedArrayAfterIteration;
    }

    private static int[] iterateThroughElementsAndSwap(final int[] ar, final int arrayIterationLimit) {
        for (int i = 0, j = 1; j < arrayIterationLimit; i++, j++) {
            if (ar[i] > ar[j]) {
                swapElements(ar, i, j);
                printArray(ar);
            }
        }
        return ar;
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

    private static void printArray(final int[] ar) {
        for (final int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

}
