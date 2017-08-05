package com.tdd;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {


    public static final Map<Character, Integer> ROMAN_TO_INTEGER_MAP = new HashMap<>();

    static {
        ROMAN_TO_INTEGER_MAP.put('I', 1);
        ROMAN_TO_INTEGER_MAP.put('V', 5);
        ROMAN_TO_INTEGER_MAP.put('X', 10);
    }

    public int convert(final String input) {
        final String roman = getSanitizedInput(input);
        int sum = 0;
        int previous = 0;

        if (roman == null)
            return sum;

        for (int i = roman.length() - 1; i >= 0; i--) {
            final char current = roman.charAt(i);

            if (isFirstIteration(i, roman) || !currentCharLessThanPrevious(previous, current)) {
                previous = ROMAN_TO_INTEGER_MAP.get(current);
                sum = sum + previous;
            } else {
                previous = ROMAN_TO_INTEGER_MAP.get(current);
                sum = sum - previous;
            }
        }
        return sum;
    }

    private boolean currentCharLessThanPrevious(final int previous, final char current) {
        return previous > ROMAN_TO_INTEGER_MAP.get(current);
    }

    private boolean isFirstIteration(final int loopIndex, final String roman) {
        return loopIndex == roman.length() - 1;
    }

    private String getSanitizedInput(final String input) {
        return input == null ? null : input.trim().toUpperCase();
    }
}
