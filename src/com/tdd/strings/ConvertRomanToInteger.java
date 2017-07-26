package com.tdd.strings;

import java.util.HashMap;
import java.util.Map;

public class ConvertRomanToInteger {

    public static void main(final String[] args) {
        System.out.println(new ConvertRomanToInteger().convertRomanToInt("III"));
        System.out.println(new ConvertRomanToInteger().convertRomanToInt("V"));
        System.out.println(new ConvertRomanToInteger().convertRomanToInt("VIII"));
        System.out.println(new ConvertRomanToInteger().convertRomanToInt("VI"));
        System.out.println(new ConvertRomanToInteger().convertRomanToInt("XI"));
        System.out.println(new ConvertRomanToInteger().convertRomanToInt("IV"));
        System.out.println(new ConvertRomanToInteger().convertRomanToInt("IX"));
        System.out.println(new ConvertRomanToInteger().convertRomanToInt("XL"));
        System.out.println(new ConvertRomanToInteger().convertRomanToInt("LX"));
        System.out.println(new ConvertRomanToInteger().convertRomanToInt("CX"));
        System.out.println(new ConvertRomanToInteger().convertRomanToInt("XC"));
        System.out.println(new ConvertRomanToInteger().convertRomanToInt("XCVII"));
        System.out.println(new ConvertRomanToInteger().convertRomanToInt("MCMLIV"));
        System.out.println(new ConvertRomanToInteger().convertRomanToInt("MCMXC"));
        System.out.println(new ConvertRomanToInteger().convertRomanToInt("MMXIV"));
    }

    private int convertRomanToInt(final String romanString) {

        final Map<Character, Integer> romanToIntegerMap = getRomanChars();
        final String capitalizedRomanStr = romanString.toUpperCase();
        int result = 0;
        int lastRomanVal = 0;
        Character lastRomanChar = null;
        for (int i = capitalizedRomanStr.length() - 1; i >= 0; i--) {
            final Character currentRomanChar = capitalizedRomanStr.charAt(i);

            final int currentRomanVal = romanToIntegerMap.get(currentRomanChar);
            if (lastRomanVal > currentRomanVal) {

                if (isFirstCharacter(lastRomanChar) || isSameCharacterAsPrevious(lastRomanChar, currentRomanChar) || isCurrentCharValid(lastRomanChar, currentRomanChar)) {
                    lastRomanChar = currentRomanChar;
                } else {
                    throw new IllegalArgumentException("invalid input");
                }

                lastRomanVal = currentRomanVal;
                result -= currentRomanVal;
            } else {
                lastRomanVal = currentRomanVal;
                lastRomanChar = currentRomanChar;
                result += currentRomanVal;
            }
        }
        return result;
    }

    private boolean isSameCharacterAsPrevious(final Character lastRomanChar, final Character currentRomanChar) {
        return lastRomanChar == currentRomanChar;
    }

    private boolean isFirstCharacter(final Character lastRomanChar) {
        return isSameCharacterAsPrevious(lastRomanChar, null);
    }

    private boolean isCurrentCharValid(final Character lastRomanChar, final Character currentRomanChar) {
        return validValues().get(lastRomanChar).equals(currentRomanChar);
    }

    private Map<Character, Integer> getRomanChars() {
        final Map<Character, Integer> romanChars = new HashMap<>();
        romanChars.put('I', 1);
        romanChars.put('V', 5);
        romanChars.put('X', 10);
        romanChars.put('L', 50);
        romanChars.put('C', 100);
        romanChars.put('D', 500);
        romanChars.put('M', 1000);
        return romanChars;
    }

    private Map<Character, Character> validValues() {
        final Map<Character, Character> validCharsBefore = new HashMap<>();
        validCharsBefore.put('I', 'I');
        validCharsBefore.put('V', 'I');
        validCharsBefore.put('X', 'I');
        validCharsBefore.put('L', 'X');
        validCharsBefore.put('C', 'X');
        validCharsBefore.put('D', 'C');
        validCharsBefore.put('M', 'C');
        return validCharsBefore;
    }
}
