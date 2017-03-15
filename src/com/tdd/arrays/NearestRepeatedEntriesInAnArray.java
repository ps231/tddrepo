package com.tdd.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//write a program that takes an array and finds the distance between the closest pair of equal entries.
//for eg; 'a, b, c, d, a, l, a, z', the second and third occurence of 'a' is the closest pair and hence distance between them is 1
public class NearestRepeatedEntriesInAnArray {

    public static void main(final String[] args) {
        final List<String> paragraph = new ArrayList<String>();
        paragraph.add("a");
        paragraph.add("b");
        paragraph.add("c");
        paragraph.add("d");
        paragraph.add("a");
        paragraph.add("b");
        paragraph.add("l");
        paragraph.add("n");
        paragraph.add("l");
        System.out.println(findClosestDistance(paragraph));
    }

    private static int findClosestDistance(final List<String> paragraph) {
        int closestDistance = Integer.MAX_VALUE;

        final Map<String, Integer> latestWordIndex = new HashMap<>();
        for (int currentIndex = 0; currentIndex < paragraph.size(); currentIndex++) {
            final String word = paragraph.get(currentIndex);
            if (latestWordIndex.get(word) == null) {
                latestWordIndex.put(word, currentIndex);
            } else {
                final int earlierIndex = latestWordIndex.get(word);
                latestWordIndex.put(word, currentIndex);
                closestDistance = Math.min(closestDistance, currentIndex - earlierIndex);
            }
        }

        return closestDistance;
    }
}
