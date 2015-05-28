package com.tdd;

public class AlternatingCharacters {

    public static boolean isValid(final String inputString) {
        if (inputString == null || inputString.isEmpty())
            return false;
        else if (!containsOnlyAAndBCharacters(inputString))
            return false;
        else
            return true;
    }

    private static boolean containsOnlyAAndBCharacters(final String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            final char c = inputString.charAt(i);
            if (c == 'A' || c == 'B') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static int getMinimumCharsToDelete(final String inputString) {
        int noOfCharsToDelete = 0;
        if (isValid(inputString)) {
            for (int i = 0; i < inputString.length() - 1; i++) {
                final char previousChar = inputString.charAt(i);
                final char nextChar = inputString.charAt(i + 1);
                if (previousChar == nextChar) {
                    noOfCharsToDelete++;
                }
            }
        }
        return noOfCharsToDelete;
    }

}
