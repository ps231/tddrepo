package com.tdd.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//given an array and a number k, we have to rotate the array by k elements
//[7, 10, 15, 4, 8] and k = 2, then the answer is [4, 8, 7, 10, 15]
public class RotateArrayByK {

    public static void main(final String[] args) {
        int [] nums = {7, 10, 15, 4, 8};
        rotateArrayUsingExtraKSpace(nums, 3);
        printArray(nums);
    }

    private static void printArray(int[] nums) {
        Arrays.stream(nums).forEach((int i) -> { System.out.println(i); });
    }

//O(n) time and O(k) space complexity
    static void rotateArrayUsingExtraKSpace(final int[] nums, final int k) {
        if (nums.length < k)
            return;

        List<Integer> listToAdd = new ArrayList<>(k);
        for (int i = nums.length - k; i < nums.length; i++) {
            listToAdd.add(nums[i]);
        }

        for (int i = nums.length - k - 1, j = nums.length - 1; i >= 0; i--, j--) {
            nums[j] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = listToAdd.get(i);
        }
    }
}
