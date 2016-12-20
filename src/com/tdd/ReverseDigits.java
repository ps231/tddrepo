package com.tdd;

// Given a integer, reverse its digits
public class ReverseDigits {

    public static void main(final String... args) {
        System.out.println("1234 = " + reverseDigits(1234));
        System.out.println("104 = " + reverseDigits(104));
    }

    public static int reverseDigits(final int number) {
        int reversedNumber = 0;
        int remaining = number;
        while (remaining != 0) {
            reversedNumber = reversedNumber * 10 + remaining % 10;
            remaining = remaining / 10;
        }

        return reversedNumber;
    }
}
