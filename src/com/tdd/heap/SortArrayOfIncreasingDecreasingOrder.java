package com.tdd.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortArrayOfIncreasingDecreasingOrder {

    public static void main(final String[] args) {
        Arrays.stream(getSortedArray(new int[]{5, 8, 15, 12, 11, 9, 10, 30, 38, 36, 29, 25}, 4)).forEach(System.out::println);
    }

    private static int[] getSortedArray(final int[] input, final int noOfTimesIncDec) {

        final Map<Integer, List<Integer>> sortedLists = new HashMap<>();
        for (int i = 0; i < noOfTimesIncDec; i++) {
            sortedLists.put(i, new LinkedList<>());
        }

        int sortedArrayNo = 0;
        final List<Integer> sortedArrayList = new LinkedList<>();

        for (int i = 0; i < input.length - 1; i++) {

            if (input[i + 1] > input[i]) {
                sortedArrayList.add(input[i]);
            } else {
                sortedLists.get(sortedArrayNo).addAll(sortedArrayList);
                sortedArrayList.clear();
                sortedArrayNo++;

                int j = i;
                while (j < input.length - 1 && input[j + 1] < input[j]) {
                    j++;
                }

                final int k = j;

                while (j >= i) {
                    sortedArrayList.add(input[j]);
                    j--;
                }

                sortedLists.get(sortedArrayNo).addAll(sortedArrayList);
                sortedArrayList.clear();
                sortedArrayNo++;
                i = k;
            }
        }

        final Queue<NextNode> minHeap = new PriorityQueue<NextNode>(noOfTimesIncDec, (o1, o2) -> {
            return o1.listVal.compareTo(o2.listVal);
        });

        final int[] sorted = new int[input.length];

        for (Map.Entry<Integer, List<Integer>> entry : sortedLists.entrySet()) {
            minHeap.add(new NextNode(entry.getKey(), entry.getValue().get(0), 0));
        }

        int i = 0;
        while (!minHeap.isEmpty()) {
            final NextNode node = minHeap.poll();
            if (node.curIdx < sortedLists.get(node.listNo).size() - 1) {
                node.curIdx++;
                minHeap.add(new NextNode(node.listNo, sortedLists.get(node.listNo).get(node.curIdx), node.curIdx));
            }
            sorted[i] = node.listVal;
            i++;
        }

        return sorted;
    }

    static class NextNode {
        private int listNo;
        private Integer listVal;
        private int curIdx;

        NextNode(final int listNo, final int listVal, final int curIdx) {
            this.listNo = listNo;
            this.listVal = listVal;
            this.curIdx = curIdx;
        }
    }
}
