package com.tdd.arrays;

import java.util.ArrayList;
import java.util.List;

public class IncrementArbitraryPrecisionInteger {

    public static void main(final String... args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(9);
        plusOne(input).forEach(System.out::println);

        input = new ArrayList<>();
        input.add(9);
        input.add(9);
        plusOne(input).forEach(System.out::println);
    }

    static List<Integer> plusOne(final List<Integer> input) {
        int carry = 1;
        for (int i = input.size() - 1; i >= 0; i--) {
            int sum = input.get(i) + carry;
            if (sum == 10) {
                input.set(i, 0);
                carry = 1;
            } else {
                input.set(i, sum);
                carry = 0;
            }
        }

        if (carry == 1)
            input.add(0, 1);

        return input;
    }
}
