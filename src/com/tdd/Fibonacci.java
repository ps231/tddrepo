package com.tdd;

public class Fibonacci {

    private static int[] series = new int[50];

    static {
        series[0] = 0;
        series[1] = 1;
    }

    public static boolean numberExists(final int numberToBeFound) {
        if (numberToBeFound < 0)
            return false;
        if (numberToBeFound == 0 || numberToBeFound == 1)
            return true;
        return findInSeries(numberToBeFound);
    }

    private static boolean findInSeries(final int numberToBeFound) {

        for (int i = 2; i < 50; i++) {
            series[i] = series[i - 1] + series[i - 2];
            if (series[i] == numberToBeFound)
                return true;
        }
        return false;
    }

}
