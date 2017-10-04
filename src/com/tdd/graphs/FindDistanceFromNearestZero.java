package com.tdd.graphs;

import java.util.LinkedList;
import java.util.Queue;

//given a matrix, we have to find the distance for any value of -1 from the nearest zero. We cannot go diagonally
public class FindDistanceFromNearestZero {
    public static void main(final String... args) {
//        final int[][] matrix = {{-1, -1, -1}, {3, 0, -1}, {1, 2, 3}};
//        final int[][] matrix = {{-1, 0, 2}, {-1, 1, 0}, {0, -1, -1}};
        final int[][] matrix = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, 0}};
        new FindDistanceFromNearestZero().findDistances(matrix);
    }

    private void findDistances(final int[][] matrix) {
        final Queue<Temp> q = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    addAdjoiningElementsWithMinus1ToQ(matrix, i, j, q);
                }
            }
        }

        while (!q.isEmpty()) {
            final Temp t = q.poll();
            if (matrix[t.i][t.j] == -1) {
                matrix[t.i][t.j] = findMinOfAdjoiningElements(matrix, t.i, t.j) + 1;
                addAdjoiningElementsWithMinus1ToQ(matrix, t.i, t.j, q);
            }
        }
    }

    private int findMinOfAdjoiningElements(final int[][] matrix, final int i, final int j) {
        int currentMin = Integer.MAX_VALUE;
        if (i - 1 >= 0)
            if (matrix[i - 1][j] != -1)
                currentMin = Math.min(currentMin, matrix[i - 1][j]);

        if (i + 1 <= matrix.length - 1)
            if (matrix[i + 1][j] != -1)
                currentMin = Math.min(currentMin, matrix[i + 1][j]);

        if (j - 1 >= 0)
            if (matrix[i][j - 1] != -1)
                currentMin = Math.min(currentMin, matrix[i][j - 1]);

        if (j + 1 <= matrix[0].length - 1)
            if (matrix[i][j + 1] != -1)
                currentMin = Math.min(currentMin, matrix[i][j + 1]);

        return currentMin;
    }

    private void addAdjoiningElementsWithMinus1ToQ(final int[][] matrix, final int i, final int j, final Queue<Temp> q) {

        if (i - 1 >= 0)
            if (matrix[i - 1][j] == -1)
                q.add(new Temp(i - 1, j));

        if (i + 1 <= matrix.length - 1)
            if (matrix[i + 1][j] == -1)
                q.add(new Temp(i + 1, j));

        if (j - 1 >= 0)
            if (matrix[i][j - 1] == -1)
                q.add(new Temp(i, j - 1));

        if (j + 1 <= matrix[0].length - 1)
            if (matrix[i][j + 1] == -1)
                q.add(new Temp(i, j + 1));

    }

    private class Temp {
        int i;
        int j;

        Temp(final int i, final int j) {
            this.i = i;
            this.j = j;
        }
    }
}
