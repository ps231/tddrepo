package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoSortedArrays {

    public static void main(String[] args) {
        Integer[] result = intersection(new Integer[]{1, 2, 3}, new Integer[]{4, 5});
        System.out.println("Iteration 1");
        printArray(result);
        result = intersection(new Integer[] {1,1,2,3,3}, new Integer[] {2,3,3,4});
        System.out.println("Iteration 2");
        printArray(result);
        result = intersection(new Integer[] {1,1,1,2,2,3,3,4}, new Integer[] {2,2,2,2,2,2,3,4,4,4});
        System.out.println("Iteration 3");
        printArray(result);
        result = intersection(new Integer[] {1,1,1}, new Integer[] {2,2,2,2});
        System.out.println("Iteration 4");
        printArray(result);
        result = intersection(new Integer[] {5,5,6,7}, new Integer[] {3,4,5,7,8});
        System.out.println("Iteration 5");
        printArray(result);
    }

    private static void printArray(Integer[] intersection) {
        for(int i : intersection) {
            System.out.println(i);
        }
    }

    private static Integer[] intersection(Integer[] a, Integer[] b) {
        List<Integer> aList = getList(a);
        List<Integer> bList = getList(b);
        List<Integer> abIntersection = new ArrayList<>();

        int i = 0, j = 0;

        while(i < aList.size() && j < bList.size()) {
            final Integer elemA = aList.get(i);
            final Integer elemB = bList.get(j);
            if (elemA == elemB) {
                addToIntersection(abIntersection, elemA);
                i++;
                j++;
            } else if (elemA < elemB) {
                i++;
            } else {
                j++;
            }
        }
        return convertToArray(abIntersection);
    }

    private static void addToIntersection(List<Integer> abIntersection, Integer elem) {
        if (abIntersection.isEmpty() || verifyLastInsertedElementIsNotSame(abIntersection, elem))
            abIntersection.add(elem);
    }

    private static boolean verifyLastInsertedElementIsNotSame(List<Integer> abIntersection, Integer elemA) {
        return abIntersection.get(abIntersection.size() - 1) != elemA;
    }

    private static Integer[] convertToArray(List<Integer> abIntersection) {
        return abIntersection.toArray(new Integer[abIntersection.size()]);
    }

    private static List<Integer> getList(Integer[] a) {
        return Arrays.asList(a);
    }
}
