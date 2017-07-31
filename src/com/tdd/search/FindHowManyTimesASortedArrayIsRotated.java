package com.tdd.search;

public class FindHowManyTimesASortedArrayIsRotated {

    public static void main(final String[] args) {
        System.out.println(new FindHowManyTimesASortedArrayIsRotated().getTimesASortedArrayIsRotated(new int[] {25, 8, 12, 15, 17, 18}));
        System.out.println(new FindHowManyTimesASortedArrayIsRotated().getTimesASortedArrayIsRotated(new int[] {18, 25, 8, 12, 15, 17}));
        System.out.println(new FindHowManyTimesASortedArrayIsRotated().getTimesASortedArrayIsRotated(new int[] {17, 18, 25, 8, 12, 15}));
        System.out.println(new FindHowManyTimesASortedArrayIsRotated().getTimesASortedArrayIsRotated(new int[] {15, 17, 18, 25, 8, 12}));
        System.out.println(new FindHowManyTimesASortedArrayIsRotated().getTimesASortedArrayIsRotated(new int[] {12, 15, 17, 18, 25, 8}));
        System.out.println(new FindHowManyTimesASortedArrayIsRotated().getTimesASortedArrayIsRotated(new int[] {8, 12, 15, 17, 18, 25}));
        System.out.println(new FindHowManyTimesASortedArrayIsRotated().getTimesASortedArrayIsRotated(new int[] {12, 15, 17, 18, 25, 8}));
        System.out.println(new FindHowManyTimesASortedArrayIsRotated().getTimesASortedArrayIsRotated(new int[] {12, 15, 17, 18, 25, 8}));
        System.out.println(new FindHowManyTimesASortedArrayIsRotated().getTimesASortedArrayIsRotated(new int[] {12, 15, 17, 18, 25, 4, 8}));
        System.out.println(new FindHowManyTimesASortedArrayIsRotated().getTimesASortedArrayIsRotated(new int[] {8, 12, 15, 17, 18, 25, 4}));
    }

    private int getTimesASortedArrayIsRotated(final int[] rotated) {

        int low = 0;
        int high = rotated.length - 1;
        int prev = -1;
        int next = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
//            if (mid == 0) {
//                prev = rotated.length - 1;
//                next = mid + 1;
//            } else if (mid == rotated.length - 1) {
//                prev = mid - 1;
//                next = 0;
//            } else {
//                prev = mid - 1;
//                next = mid + 1;
//            }
            prev = (mid + rotated.length - 1) % rotated.length;
            next = (mid + 1) % rotated.length;

            if (rotated[mid] < rotated[next] && rotated[mid] < rotated[prev]) {
                return mid;
            }

            if (rotated[high] > rotated[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
