package com.tdd.dp;

//write a program which takes as inputs n steps and k (1 to k steps at a time) steps and returns the number of ways
//in which you can reach your destination.
//n = 4 and k = 2, there are 5 ways.
//1-1-1-1
//1-1-2
//1-2-1
//2-1-1
//2-2
//if k = 3, add these two combinations
//1-3
//3-1

public class NoOfCombinationsToClimbStairs {

    public static void main(final String... args) {
        System.out.println(NoOfCombinationsToClimbStairs.numberOfWaysToTop(4, 2));
    }

    public static int numberOfWaysToTop(final int top, final int maxStep) {
        return calculateWays(top, maxStep, 0);
    }

    private static int calculateWays(final int top, final int maxStep, int sum) {
        if (top == 0 || top == 1) {
            return sum + 1;
        }
        for (int i = 1; i <= maxStep && top - i >= 0; i++) {
            sum = calculateWays(top - i, maxStep, sum);
        }
        return sum;
    }
}
