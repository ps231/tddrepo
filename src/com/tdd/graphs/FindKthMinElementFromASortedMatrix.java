package com.tdd.graphs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindKthMinElementFromASortedMatrix {

    public static void main(final String... args) {
        final int[][] matrix = {{1, 5, 9}, {2, 7, 11}, {3, 8, 15}};
        System.out.println(new FindKthMinElementFromASortedMatrix().kthSmallest(matrix, 8));
    }


    public int kthSmallest(final int[][] matrix, final int k) {

        if (matrix == null)
            return -1;

        if (k < 0 || k > matrix.length * matrix.length)
            return -1;

        if (k == 1)
            return matrix[0][0];

        if (k == matrix.length * matrix.length)
            return matrix[matrix.length - 1][matrix.length - 1];

        final PriorityQueue<Temp> minHeap = new PriorityQueue<>(Comparator.comparingInt(t -> t.val));
        final Map<Temp, Boolean> existingMins = new HashMap<>();

        int count = 1;
        Temp right = new Temp(0, 1, matrix[0][1]);
        Temp down = new Temp(1, 0, matrix[1][0]);

        if (existingMins.get(right) == null) {
            existingMins.put(right, true);
            minHeap.add(right);
        }

        if (existingMins.get(down) == null) {
            existingMins.put(down, true);
            minHeap.add(down);
        }

        while (true) {
            if (minHeap.isEmpty())
                break;

            final Temp t = minHeap.poll();
            count++;

            if (count == k)
                return t.val;

            right = getRight(t, matrix, existingMins);
            down = getDown(t, matrix, existingMins);

            if (right != null)
                minHeap.add(right);
            if (down != null)
                minHeap.add(down);

        }
        return -1;
    }

    private Temp getRight(final Temp t, final int[][] matrix, final Map<Temp, Boolean> existingMins) {
        Temp temp = null;
        if (t.j + 1 <= matrix.length - 1 && existingMins.get(new Temp(t.i, t.j + 1, matrix[t.i][t.j + 1])) == null) {
            existingMins.put(new Temp(t.i, t.j + 1, matrix[t.i][t.j + 1]), true);
            temp = new Temp(t.i, t.j + 1, matrix[t.i][t.j + 1]);
        }
        return temp;
    }


    private Temp getDown(final Temp t, final int[][] matrix, final Map<Temp, Boolean> existingMins) {
        Temp temp = null;

        if (t.i + 1 <= matrix.length - 1) {
            final Temp key = new Temp(t.i + 1, t.j, matrix[t.i + 1][t.j]);
            if (existingMins.get(key) == null) {
                existingMins.put(key, true);
                temp = key;
            }
        }
        return temp;
    }

    private class Temp {
        int i;
        int j;
        int val;

        Temp(final int i, final int j, final int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            result = 31 * result + val;
            return result;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Temp temp = (Temp) o;

            if (i != temp.i) return false;
            if (j != temp.j) return false;
            return val == temp.val;
        }

    }
}

