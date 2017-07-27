package com.tdd.strings.combinations;

public class PrintAllCombinations {

    public static void main(final String[] args) {
        new PrintAllCombinations().printAllCombinations("abc");
    }

    public void printAllCombinations(final String input) {
        final boolean[] used = new boolean[input.length()];
        final char[] result = new char[input.length()];
        printCombinations(input.toCharArray(), used, 0, result);
    }

    private void printCombinations(final char[] input, final boolean[] used, final int level, final char[] result) {
        if (level == result.length)
            System.out.println(new String(result));

        for (int i = 0; i < input.length; i++) {
            if (!used[i]) {
                result[level] = input[i];
                used[i] = true;
                printCombinations(input, used, level + 1, result);
                used[i] = false;
            }
        }
    }
}
