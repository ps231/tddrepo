package com.tdd.strings;

public class Pangram {

    private String inputStr;
    private final boolean[] alphabets = new boolean[26];

    public Pangram(final String str) {
        validateArgument(str);
        this.inputStr = str.toUpperCase();
    }

    private void validateArgument(final String str) {
        if (str == null || str.trim().length() < 1 || str.trim().length() > 1000) {
            throw new IllegalArgumentException("invalid string argument");
        }
    }

    public boolean isPangram() {
        inputStr = inputStr.replace(" ", "");
        for (int i = 0; i < inputStr.length(); i++) {
            final char inputChar = inputStr.charAt(i);
            final int charIndex = inputChar - 65;
            alphabets[charIndex] = true;
        }
        for (int i = 0; i < alphabets.length; i++) {
            if (!alphabets[i]) {
                return false;
            }
        }
        return true;
    }

}
