package com.tdd.recursion;

public class SearchElementIn2DSortedMatrix {

    public static void main(final String... args) {
        System.out.println(new SearchElementIn2DSortedMatrix().searchMatrix(new int[][]{{1, 4, 17}, {2, 5, 18}, {23, 26, 29}}, 26));
        System.out.println(new SearchElementIn2DSortedMatrix().searchMatrix(new int[][]{{1, 4, 17}, {2, 5, 18}, {23, 26, 29}}, 25));
        System.out.println(new SearchElementIn2DSortedMatrix().searchMatrix(new int[][]{{1, 4, 17}, {2, 5, 18}, {23, 26, 29}}, 4));
    }

    private boolean searchMatrix(final int[][] matrix, final int target) {

        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix.length - 1])
            return false;

        if (target == matrix[0][0] || target == matrix[matrix.length - 1][matrix.length - 1])
            return true;

        return recurseMatrix(matrix, target, 0, 0);
    }

    private boolean recurseMatrix(int[][] matrix, int target, int i, int j) {

        for (int m = i; m < matrix.length; m++) {
            for (int n = j; n < matrix.length; n++) {
                if (matrix[m][n] == target)
                    return true;

                if (target > matrix[matrix.length - 1][n] && target > matrix[m][matrix.length - 1])
                    return recurseMatrix(matrix, target, m + 1, n + 1);

                if (target > matrix[matrix.length - 1][n])
                    return recurseMatrix(matrix, target, m, n + 1);

                if (target > matrix[m][matrix.length - 1])
                    return recurseMatrix(matrix, target, m + 1, n);
            }
        }
        return false;
    }
}
