package com.tdd.search;

// find the minimum element in a sorted rotated array
public class FindMinElemInSortedRotatedArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String... args) {
        FindMinElemInSortedRotatedArray a = new FindMinElemInSortedRotatedArray();
        System.out.println(a.findMin(new int[] {0,1,2,3,4,5,6}));
        System.out.println(a.findMin(new int[] {4,5,6,7,0,1,2}));
        System.out.println(a.findMin(new int[] {2,3,4,5,1}));
        System.out.println(a.findMin(new int[] {3,1,2}));
        System.out.println(a.findMin(new int[] {1,2}));
    }
}
