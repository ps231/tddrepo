package com.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSortPartition {
    public static int[] partition(final int[] ar) {
        validate(ar);
        final int pivot = getPivotElement(ar);
        final int[] lesserElems = getLesserElements(ar, pivot);
        final int[] greaterElems = getGreaterElements(ar, pivot);
        return populateArray(lesserElems, pivot, greaterElems, ar.length);
    }

    private static int[] populateArray(final int[] lesserElems, final int pivot, final int[] greaterElems, final int length) {
        final int[] finalAr = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < lesserElems.length; j++, i++) {
                finalAr[i] = lesserElems[j];
            }

            finalAr[i++] = pivot;

            for (int j = 0; j < greaterElems.length; j++, i++) {
                finalAr[i] = greaterElems[j];
            }
        }
        printArray(finalAr);
        return finalAr;
    }

    private static void printArray(final int[] ar) {
        for (final int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
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
        if (elem < -1000 || elem > 1000) {
            throw new IllegalArgumentException("array elem is invalid");
        }
    }

    private static int getPivotElement(final int[] ar) {
        return ar[0];
    }

    private static int[] getLesserElements(final int[] ar, final int pivot) {
        final int[] lesserElems = new int[ar.length];

        int insertCount = 0;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] <= pivot) {
                lesserElems[insertCount++] = ar[i];
            }
        }
        return Arrays.copyOfRange(lesserElems, 0, insertCount);
    }

    private static int[] getGreaterElements(final int[] ar, final int pivot) {
        final int[] greaterElems = new int[ar.length];

        int insertCount = 0;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] > pivot) {
                greaterElems[insertCount++] = ar[i];
            }
        }
        return Arrays.copyOfRange(greaterElems, 0, insertCount);
    }

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        partition(ar);
    }
}
