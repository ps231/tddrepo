package com.tdd.arrays;

import java.util.Arrays;
import java.util.HashSet;

// [4 8 5 9 3 10 2 0], longest length is 4 for 2 3 4 5
// [100 33 34 200 400 35] longest length is 3 for 33 34 35
public class FindLongestConsecutiveElementsInAnUnsortedArray {

    public static void main(final String... args) {
        System.out.println(findLongestLen(new int[] {4, 8, 5, 9, 3, 10, 2, 0, 7, 11}));
        System.out.println(findLongestLen(new int[] {100, 33, 34, 200, 400, 35}));
        System.out.println(findLongestLen(new int[] {1, 2, 5, 4, 3}));
        System.out.println(findLongestLen(new int[] {10, 2, 50, 44, 31}));


        System.out.println(findLongestLenWithBetterTime(new int[] {4, 8, 5, 9, 3, 10, 2, 0, 7, 11}));
        System.out.println(findLongestLenWithBetterTime(new int[] {100, 33, 34, 200, 400, 35}));
        System.out.println(findLongestLenWithBetterTime(new int[] {1, 2, 5, 4, 3}));
        System.out.println(findLongestLenWithBetterTime(new int[] {10, 2, 50, 44, 31}));

    }

//    O(nlogn) solution with no space
    public static int findLongestLen(final int [] nums) {
        Arrays.sort(nums);

        int len = 0;
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == 1) {
                len++;
                maxLen = Math.max(maxLen, len);
            } else {
                len = 0;
            }
        }
        return maxLen + 1;
    }

//    O(n) solution with O(n) space
    public static int findLongestLenWithBetterTime(final int [] nums) {

        final HashSet<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            numbers.add(num);
        }

        int len = 1;
        int maxLen = Integer.MIN_VALUE;

        for (int num : nums) {
            len = findConsecutiveNextElements(num, len, numbers);
            len = findConsecutivePrevElements(num, len, numbers);
            maxLen = Math.max(maxLen, len);
            len = 1;
        }
        return maxLen;
    }

    private static int findConsecutivePrevElements(int num, int len, final HashSet<Integer> numbers) {
        while (numbers.contains(num - 1)) {
            numbers.remove(num - 1);
            len++;
            num--;
        }
        return len;
    }

    private static int findConsecutiveNextElements(int num, int len, final HashSet<Integer> numbers) {
        while (numbers.contains(num + 1)) {
            numbers.remove(num + 1);
            len++;
            num++;
        }
        return len;
    }
}
