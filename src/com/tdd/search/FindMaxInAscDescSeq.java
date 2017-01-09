package com.tdd.search;

// find max element in a strictly ascending and then descending sequence

public class FindMaxInAscDescSeq {

    public int findMax(int[] nums) {
        int left = 0, right = nums.length - 1;

        if(nums.length==1 || nums.length==2)
            throw new IllegalArgumentException("array length should atleast be 3 to have asc and desc seq");

        while(left<right) {
            int mid = left + (right-left)/2;

            if(nums[mid] < nums[mid+1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String... args) {
        FindMaxInAscDescSeq a = new FindMaxInAscDescSeq();
        System.out.println(a.findMax(new int[] {1,2,5,6,3,0}));
        System.out.println(a.findMax(new int[] {3,8,6,5,2,1}));
        System.out.println(a.findMax(new int[] {1,2,3,4,0,-3}));
        System.out.println(a.findMax(new int[] {1,3,2}));
        System.out.println(a.findMax(new int[] {1,2}));
    }
}
