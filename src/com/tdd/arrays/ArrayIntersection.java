package com.tdd.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/intersection-of-two-arrays/#/description
public class ArrayIntersection {

    public static void main(final String... args) {
        ArrayIntersection a = new ArrayIntersection();
        Arrays.stream(a.intersection(new int[]{1, 2, 3, 3, 3, 2}, new int[]{1, 1, 1, 3, 3, 3, 3})).forEach(System.out::println);
        Arrays.stream(a.intersection(new int[]{1, 2, 3, 3, 3, 2}, new int[]{4, 5, 6, 2})).forEach(System.out::println);
    }

    public int[] intersection(final int[] nums1, final int[] nums2) {
        final Set<Integer> original = new HashSet<Integer>();
        final Set<Integer> intersection = new HashSet<Integer>();

        if (nums1.length >= nums2.length) {
            addArrayElementsToSet(original, nums1);
            populateIntersection(intersection, original, nums2);
        } else {
            addArrayElementsToSet(original, nums2);
            populateIntersection(intersection, original, nums1);
        }

        final int[] arrayIntersection = new int[intersection.size()];
        int i = 0;
        for (final int num : intersection) {
            arrayIntersection[i++] = num;
        }

        return arrayIntersection;
    }

    private void addArrayElementsToSet(final Set<Integer> original, final int[] nums) {
        Arrays.stream(nums).forEach((final int num) -> original.add(num));
    }

    private void populateIntersection(final Set<Integer> intersection, final Set<Integer> original, final int[] nums) {
        Arrays.stream(nums).forEach((final int num) -> {
            if (original.contains(num)) {
            intersection.add(num);
        }});
    }
}
