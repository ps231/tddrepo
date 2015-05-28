package com.tdd;

import java.util.Scanner;

public class Solution {

    private int height = 1;

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int noOfTestCases = in.nextInt();
        if (noOfTestCases >= 1 && noOfTestCases <= 10) {
            for (int i = 0; i < noOfTestCases; i++) {
                final int growthCycle = in.nextInt();
                System.out.println(new Solution().findHeight(growthCycle));
            }
        }
    }

    public int findHeight(final int growthCycle) {
        validateGrowthCycle(growthCycle);
        if (growthCycle == 0) {
            return height;
        } else {
            for (int i = 1; i <= growthCycle; i++) {
                if (isSummer(i)) {
                    height += 1;
                } else {
                    height *= 2;
                }
            }
            return height;
        }
    }

    private boolean isSummer(final int i) {
        return i % 2 == 0;
    }

    private void validateGrowthCycle(final int growthCycle) {
        if (growthCycle < 0 || growthCycle > 60)
            throw new IllegalArgumentException("invalid growth cycle");
    }
    //
    // private static boolean isValid(final String inputString) {
    // if (inputString == null || inputString.isEmpty())
    // return false;
    // else if (inputString.length() <= 0 || inputString.length() > 100000)
    // return false;
    // else if (!containsOnlyAAndBCharacters(inputString))
    // return false;
    // else
    // return true;
    // }
    //
    // private static boolean containsOnlyAAndBCharacters(final String
    // inputString) {
    // for (int i = 0; i < inputString.length(); i++) {
    // final char c = inputString.charAt(i);
    // if (c == 'A' || c == 'B') {
    // continue;
    // } else {
    // return false;
    // }
    // }
    // return true;
    // }
    //
    // private static int getMinimumCharsToDelete(final String inputString) {
    // int noOfCharsToDelete = 0;
    // if (isValid(inputString)) {
    // for (int i = 0; i < inputString.length() - 1; i++) {
    // final char previousChar = inputString.charAt(i);
    // final char nextChar = inputString.charAt(i + 1);
    // if (previousChar == nextChar) {
    // noOfCharsToDelete++;
    // }
    // }
    // }
    // return noOfCharsToDelete;
    // }
}