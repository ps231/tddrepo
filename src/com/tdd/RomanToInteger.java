package com.tdd;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {


    public int convert(final String input) {
        final String roman = getSanitizedInput(input);
        final Map<Character, Integer> romanToIntMap = getRomanToIntegerMap();
        int sum = 0;
        int previous = 0;

        if (roman == null)
            return sum;

        for (int i = roman.length() - 1; i >= 0; i--) {
            final char r = roman.charAt(i);

            if (isFirstIteration(i, roman) || !currentCharLessThanPrevious(romanToIntMap, previous, r)) {
                previous = romanToIntMap.get(r);
                sum = sum + previous;
            } else {
                previous = romanToIntMap.get(r);
                sum = sum - previous;
            }
        }
        return sum;
    }

    private boolean currentCharLessThanPrevious(final Map<Character, Integer> romanToIntMap, final int previous, final char r) {
        return previous > romanToIntMap.get(r);
    }

    private boolean isFirstIteration(final int loopIndex, final String roman) {
        return loopIndex == roman.length() - 1;
    }

    private Map<Character, Integer> getRomanToIntegerMap() {
        final Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        return map;
    }

    private String getSanitizedInput(final String input) {
        return input == null ? null : input.trim().toUpperCase();
    }
}
