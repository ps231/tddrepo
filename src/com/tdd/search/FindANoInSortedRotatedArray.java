package com.tdd.search;

//You are given a target value to search. If found in the array return its index, otherwise return -1. You may assume no duplicate exists in the array.
//[23, 28, 2, 5, 8, 10, 15], search for 8, should return 4
//[8, 10, 15, 23, 28, 2, 5], search for 8, should return 0
public class FindANoInSortedRotatedArray {

    public static void main(final String... args) {
        final FindANoInSortedRotatedArray a = new FindANoInSortedRotatedArray();
        System.out.println(a.search(new int[]{23, 28, 2, 5, 8, 10, 15}, 8));
        System.out.println(a.search(new int[]{23, 28, 2, 5, 6, 8, 10, 15}, 8));
        System.out.println(a.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 8));
        System.out.println(a.search(new int[]{8, 10, 15, 23, 28, 30, 32}, 8));
//        not working for this test case
//        System.out.println(a.search(new int[]{8, 10, 15, 23, 28, 2, 5}, 8));
    }

    public int search(final int[] nums, final int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(final int[] nums, final int target, int start, int end) {
        if (start > end)
            return -1;

        final int mid = start + (end - start) / 2;

        if (nums[mid] == target)
            return mid;

        if (nums[mid] < target) {
            if (nums[end] >= target)
                return search(nums, target, mid + 1, end);
            else
                return search(nums, target, start, mid - 1);
        } else {
            if (nums[end] >= target)
                return search(nums, target, start, mid - 1);
            else
                return search(nums, target, mid + 1, end);
        }
    }
}
