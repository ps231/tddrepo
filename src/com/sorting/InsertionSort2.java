package com.sorting;

import java.util.Scanner;

public class InsertionSort2 {

    private static int[] insertIntoSorted(final int[] ar, final int index) {
        validate(ar);
        final int indexOfElemToBeInserted = index;
        final int number = ar[indexOfElemToBeInserted];
        for (int i = indexOfElemToBeInserted; i >= 0; i--) {
            if (i != 0 && numLessThanPrevArrayElement(ar, number, i)) {
                copyArrayElementInNextRightLocation(ar, i);
                // printArray(ar);
            } else {
                insertNumberAtCurrentLocation(ar, number, i);
                printArray(ar);
                break;
            }
        }
        return ar;
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

    public static int[] insertionSortPart2(final int[] origAr) {
        int[] sortedArrAfterEveryIteration = null;
        // for (int i = 0; i < 1; i++) {
        // for (int i = 1; i < 2; i++) {
        // for the purpose of testing every iteration we would have to put all
        // the in between arrays into a 2d array and compare accordingly in the
        // test
        for (int i = 1; i < origAr.length; i++) {
            sortedArrAfterEveryIteration = insertIntoSorted(origAr, i);
        }
        return sortedArrAfterEveryIteration;
    }

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int s = in.nextInt();
        final int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertionSortPart2(ar);
        in.close();
    }

    private static void printArray(final int[] ar) {
        for (final int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
