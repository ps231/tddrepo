package com.sorting;

import java.util.Arrays;
import java.util.List;

//Merge two sorted arrays into the first array. Assume the first array has enough empty spots to hold the entire result.
public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        Integer[] result = merge(new Integer[]{1, 2, 3, null, null}, new Integer[]{4, 5});
        System.out.println("Iteration 1");
        printArray(result);
        result = merge(new Integer[] {5,13,17,null,null,null,null,null}, new Integer[] {3,7,11,19});
        System.out.println("Iteration 2");
        printArray(result);
        result = merge(new Integer[] {13,17,null,null,null,null,null}, new Integer[] {1,3,7,11,19});
        System.out.println("Iteration 3");
        printArray(result);
    }

    private static Integer[] merge(Integer[] a, Integer[] b) {
        List<Integer> aList = getList(a);
        List<Integer> bList = getList(b);

        final int firstEmptyIndex = aList.indexOf(null);
        int lastMergeIndex = firstEmptyIndex + bList.size() - 1;

        int i = firstEmptyIndex - 1, j = bList.size() - 1;

        while(j >= 0 && i >= 0) {
            if (aList.get(i) > bList.get(j)) {
                aList.set(lastMergeIndex--, aList.get(i--));
            } else {
                aList.set(lastMergeIndex--, bList.get(j--));
            }
        }

        while(j >= 0) {
            aList.set(lastMergeIndex--, bList.get(j--));
        }

        return convertToArray(aList);
    }

    private static void printArray(Integer[] intersection) {
        for(Integer i : intersection) {
            System.out.println(i);
        }
    }


    private static Integer[] convertToArray(List<Integer> abIntersection) {
        return abIntersection.toArray(new Integer[abIntersection.size()]);
    }

    private static List<Integer> getList(Integer[] a) {
        return Arrays.asList(a);
    }
}
