package com.tdd;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(final String... args) {
        List<List<Integer>> triangle = new ArrayList<>();
        generatePascalsTriangle(triangle, 1);
        printTriangle(triangle);

        triangle = new ArrayList<>();
        generatePascalsTriangle(triangle, 2);
        printTriangle(triangle);

        triangle = new ArrayList<>();
        generatePascalsTriangle(triangle, 3);
        printTriangle(triangle);

        triangle = new ArrayList<>();
        generatePascalsTriangle(triangle, 4);
        printTriangle(triangle);

        triangle = new ArrayList<>();
        generatePascalsTriangle(triangle, 5);
        printTriangle(triangle);
    }

    private static void generatePascalsTriangle(final List<List<Integer>> triangle, final int rows) {
        if (rows == 1) {
            final List<Integer> rowDetails = new ArrayList<>();
            rowDetails.add(1);
            triangle.add(rowDetails);
        } else if (rows >= 2) {
            List<Integer> rowDetails = new ArrayList<>();
            rowDetails.add(1);
            triangle.add(rowDetails);
            rowDetails = new ArrayList<>();
            rowDetails.add(1);
            rowDetails.add(1);
            triangle.add(rowDetails);
        }

        for (int i = 3; i <= rows; i++) {
            final List<Integer> prevRow = triangle.get(i - 2);
            final List<Integer> newRow = initializeNewRow(i);

            for (int j = 1; j < i - 1; j++) {
                newRow.set(j, prevRow.get(j - 1) + prevRow.get(j));
            }
            triangle.add(newRow);
        }
    }

    private static List<Integer> initializeNewRow(final int size) {
        final List<Integer> newRow = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            newRow.add(0);
        }
        newRow.set(0, 1);
        newRow.set(newRow.size() - 1, 1);
        return newRow;
    }

    private static void printTriangle(final List<List<Integer>> triangle) {
        triangle.stream().forEach((List<Integer> row) -> { row.stream().forEach(System.out::print);
                                                            System.out.println();} );
    }
}
