package com.tdd.arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromASortedArray {

    public static void main(final String... args) {
        int[] nums = {1, 2, 2, 3, 4, 4, 4, 5, 5, 6, 6, 6, 7};
        RemoveDuplicatesFromASortedArray.removeDuplicates(nums);
        Arrays.stream(nums).forEach(System.out::println);

        System.out.println("--");
        nums = new int[]{1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 7};
        RemoveDuplicatesFromASortedArray.removeDuplicates(nums);
        Arrays.stream(nums).forEach(System.out::println);

        System.out.println("--");
        nums = new int[]{1, 2, 3};
        RemoveDuplicatesFromASortedArray.removeDuplicates(nums);
        Arrays.stream(nums).forEach(System.out::println);

        System.out.println("--");
        nums = new int[]{1, 2, 3, 4, 4, 4, 5};
        RemoveDuplicatesFromASortedArray.removeDuplicates(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private static void removeDuplicates(final int[] nums) {
        boolean dupFound = false;
        int duplicates = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                dupFound = true;
                duplicates++;
            } else if (dupFound) {
                nums[i - duplicates] = nums[i];
            }
        }
    }
}
