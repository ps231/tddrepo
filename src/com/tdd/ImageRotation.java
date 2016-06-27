package com.tdd;

import static com.sun.tools.doclint.Entity.image;
import static sun.misc.Version.print;

//https://leetcode.com/problems/rotate-image/
public class ImageRotation {

    public static void main(String... args) {
        System.out.println("hello");
//        int [][] image = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };


//        int [][] image = {
//                {1, 2, 3},
//                {5, 6, 7},
//                {9, 10, 11}
//        };

        int [][] image = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        int matrixSize = image[0].length-1;
        int k = 0;
        int j = 0;
        for(int rings = image[0].length / 2; rings > 0; rings--, matrixSize--, k++, j++) {

            for (int i = matrixSize, l = k; i > j; i--, l++) {

                int tmp = image[j][l];
//            3,0 -> 0,0
                image[j][l] = image[i][j];

                int tmp1 = image[l][matrixSize];
//            0,0 -> 0,3
                image[l][matrixSize] = tmp;

                tmp = image[matrixSize][i];
//            0,3 -> 3,3
                image[matrixSize][i] = tmp1;

                image[i][j] = tmp;
//            3,3 -> 3,0

            }
            print(image, 3);
        }
    }

    private static void print(int[][] image, int matrixSize) {

        for(int i = 0; i<image[0].length; i++) {
            for (int j =0; j<image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
