package com.tdd;

// given x and y, calculate x^y
public class PowerFunction {

    public static void main(final String... args) {
        System.out.println("2^2 = " + powerFunction(2, 2));
        System.out.println("2^3 = " + powerFunction(2, 3));
        System.out.println("-2^3 = " + powerFunction(-2, 3));
        System.out.println("-2^4 = " + powerFunction(-2, 4));
//        System.out.println("2^-3 = " + powerFunction(2, -3));
//        System.out.println("2^-4 = " + powerFunction(2, -4));
    }

    public static double powerFunction(final int number, final int power) {
        if (power == 1){
            return number;
        }
        if (power == 0){
            return 1;
        }
        final double powNbyTwo = powerFunction(number, power / 2);
        return powNbyTwo * powNbyTwo * powerFunction(number, power % 2);
    }
}
