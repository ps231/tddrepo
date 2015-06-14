package com.sorting;

import java.util.Scanner;

public class InsertionSortWithShifts {

    private static int insertIntoSorted(final int[] ar, final int index) {
        validate(ar);
        int shiftsInCurrentIteration = 0;
        final int indexOfElemToBeInserted = index;
        final int number = ar[indexOfElemToBeInserted];
        for (int i = indexOfElemToBeInserted; i >= 0; i--) {
            if (i != 0 && numLessThanPrevArrayElement(ar, number, i)) {
                copyArrayElementInNextRightLocation(ar, i);
                // printArray(ar);
                shiftsInCurrentIteration++;
            } else {
                insertNumberAtCurrentLocation(ar, number, i);
                // printArray(ar);
                break;
            }
        }
        return shiftsInCurrentIteration;
    }

    private static void insertNumberAtCurrentLocation(final int[] ar, final int number, final int i) {
        ar[i] = number;
    }

    private static int copyArrayElementInNextRightLocation(final int[] ar, final int i) {
        return ar[i] = ar[i - 1];
    }

    private static boolean numLessThanPrevArrayElement(final int[] ar, final int val, final int i) {
        return val < ar[i - 1];
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

    public static int calculateTotalShifts(final int[] origAr) {
        int totalShifts = 0;
        for (int i = 1; i < origAr.length; i++) {
            totalShifts += insertIntoSorted(origAr, i);
        }
        return totalShifts;
    }

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int s = in.nextInt();
        final int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        calculateTotalShifts(ar);
        in.close();
    }

    // private static void printArray(final int[] ar) {
    // for (final int n : ar) {
    // System.out.print(n + " ");
    // }
    // System.out.println("");
    // }
}
