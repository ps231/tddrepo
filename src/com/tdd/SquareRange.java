package com.tdd;

public class SquareRange {

    public static int getCountOfSquareIntegersWithin(final long lowerBound, final long upperBound) {
        validateRange(lowerBound, upperBound);
        int squareIntegerCount = 0;
        for (long i = 1; i < 100000; i++) {
            final long square = getSquare(i);
            if (squareValueWithinBounds(square, lowerBound, upperBound)) {
                squareIntegerCount++;
            } else if (squareValueGreaterThanUpperBound(square, upperBound)) {
                break;
            }
        }
        return squareIntegerCount;
    }

    private static void validateRange(final long lowerBound, final long upperBound) {
        validate(lowerBound);
        validate(upperBound);
        validateLowerBoundLessThanUpperBound(lowerBound, upperBound);
    }

    private static void validateLowerBoundLessThanUpperBound(final long lowerBound, final long upperBound) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException("Lower bound should not be greater than upper bound");
        }
    }

    private static void validate(final long bound) {
        if (bound < 1 || bound > 1000000000L) {
            throw new IllegalArgumentException("Lower bound should not be less than 1");
        }
    }

    private static boolean squareValueGreaterThanUpperBound(final long square, final long upperBound) {
        return square > upperBound;
    }

    private static boolean squareValueWithinBounds(final long square, final long lowerBound, final long upperBound) {
        return square >= lowerBound && square <= upperBound;
    }

    private static long getSquare(final long i) {
        return (long) i * i;
    }

}