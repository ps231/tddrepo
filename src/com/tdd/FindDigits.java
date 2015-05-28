package com.tdd;

import java.util.ArrayList;
import java.util.List;

public class FindDigits {

    public static void validateNumber(final long number) {
        if (number <= 0 || number > 10000000000L) {
            throw new IllegalArgumentException("negative numbers not allowed");
        }

    }

    public static List<Integer> getDigitsListExceptZero(long number) {
        validateNumber(number);
        final List<Integer> digitsList = new ArrayList<Integer>();
        while (number > 0) {
            addDigitToTheList(number, digitsList);
            number /= 10;
        }
        return digitsList;
    }

    private static void addDigitToTheList(final long number, final List<Integer> digitsList) {
        final int digit = (int) number % 10;
        if (digit > 0) {
            digitsList.add(digit);
        }

    }

    public static int getDigitsThatExactlyDivideTheNumber(final long number) {
        int noOfDigitsThatExactlyDivideTheNumber = 0;
        final List<Integer> digitsList = getDigitsListExceptZero(number);
        for (final int digit : digitsList) {
            if (digitExactlyDividesTheNumber(digit, number)) {
                noOfDigitsThatExactlyDivideTheNumber++;
            }
        }

        return noOfDigitsThatExactlyDivideTheNumber;
    }

    private static boolean digitExactlyDividesTheNumber(final int digit, final long number) {
        if (number % digit == 0) {
            return true;
        }
        return false;
    }

}
