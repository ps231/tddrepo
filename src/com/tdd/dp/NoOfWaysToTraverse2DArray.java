package com.tdd.dp;

//given that you start at the top left corner of a 2d matrix m x n, count no of ways to get to the bottom right corner.
//All moves must either go right or down
public class NoOfWaysToTraverse2DArray {

    public static void main(final String... args) {
        System.out.println("3x3 matrix ways " + NoOfWaysToTraverse2DArray.numberOfWays(3,3));
        System.out.println("5x5 matrix ways " + NoOfWaysToTraverse2DArray.numberOfWays(5,5));
        System.out.println("3x4 matrix ways " + NoOfWaysToTraverse2DArray.numberOfWays(3,4));
    }

    public static int numberOfWays(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 || col == 0)
                    matrix[row][col] = 1;
                else
                    matrix[row][col] = matrix[row - 1][col] + matrix[row][col - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }
}
