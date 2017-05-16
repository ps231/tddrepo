package com.tdd.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ArraySortByFreq {

    public static void main(final String[] args) {
//        new ArraySortByFreq().sortByFreq(new int[]{3, 1, 2, 2, 4}).stream().forEach(System.out::println);
        new ArraySortByFreq().sortByFreq(new int[]{3, 5, 2, 2, 4, 3, 3, 1}).stream().forEach(System.out::println);
    }

    private List<Integer> sortByFreq(final int[] nums) {

        Map<Integer, Integer> freqMap = createNumFreq(nums);

        Map<Integer, List<Integer>> freqSortedMap = freqSort(freqMap);

        List<Integer> listSortedByFreq = new ArrayList<>();
        for (int freq : freqSortedMap.keySet()) {
            addNumbersToSortedList(freqSortedMap, listSortedByFreq, freq);
        }

        return listSortedByFreq;
    }

    private void addNumbersToSortedList(Map<Integer, List<Integer>> freqSortedMap, List<Integer> listSortedByFreq, int freq) {
        Collections.sort(freqSortedMap.get(freq));
        for(int num : freqSortedMap.get(freq)) {
            int i = 0;
            while (i < freq) {
                listSortedByFreq.add(num);
                i++;
            }
        }
    }

    private Map<Integer, List<Integer>> freqSort(final Map<Integer, Integer> freqMap) {
        Map<Integer, List<Integer>> treeMap = new TreeMap<>();

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (treeMap.get(entry.getValue()) == null) {
                final List<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                treeMap.put(entry.getValue(), list);
            } else {
                final List<Integer> list = treeMap.get(entry.getValue());
                list.add(entry.getKey());
                treeMap.put(entry.getValue(), list);
            }
        }

        return treeMap;
    }

    private Map<Integer, Integer> createNumFreq(final int[] nums) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : nums) {
            if (map.get(num) == null)
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
        }

        return map;
    }
}
