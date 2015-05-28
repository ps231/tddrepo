package com.tdd;

public class ChocolateStore {

    public static int getMaxChocolates(final int amount, final int pricePerChocolate, final int wrappers) {
        validate(amount, 2, 105, "amount");
        validate(pricePerChocolate, 1, amount, "pricePerChocolate");
        validate(wrappers, 2, amount, "wrappers");

        int maxNoOfChocolates = 0;

        int boughtChocolates = buyChocolates(amount, pricePerChocolate);
        maxNoOfChocolates += boughtChocolates;

        while (wrappersAreAvailableToGetFreeChocolates(boughtChocolates, wrappers)) {
            final int freeChocolates = getFreeChocolates(boughtChocolates, wrappers);
            maxNoOfChocolates += freeChocolates;
            boughtChocolates = freeChocolates + getRemainingWrappers(boughtChocolates, wrappers);
        }

        return maxNoOfChocolates;
    }

    private static int getRemainingWrappers(final int boughtChocolates, final int wrappers) {
        return boughtChocolates % wrappers;
    }

    private static int getFreeChocolates(final int boughtChocolates, final int wrappers) {
        return boughtChocolates / wrappers;
    }

    private static boolean wrappersAreAvailableToGetFreeChocolates(final int boughtWrappers, final int wrappers) {
        return boughtWrappers >= wrappers;
    }

    private static int buyChocolates(final int amount, final int pricePerChocolate) {
        return amount / pricePerChocolate;
    }

    private static void validate(final int value, final int minRange, final int maxRange, final String inputParam) {
        if (!(value >= minRange && value <= maxRange)) {
            throw new IllegalArgumentException("invalid" + inputParam);
        }
    }

}
