package com.tdd;

/**
 * Created by shindikp on 6/27/16.
 */
public class KangarooHopping {
    public static boolean willLandAtSameLocation(int k1, int j1, int k2, int j2) {

        if(k1 >= k2)
            throw new IllegalArgumentException("");
        if(k1 < 0 || k2 > 10000)
            throw new IllegalArgumentException("");
        if((j1 < 1 || j1 > 10000) && (j2 < 1 || j2 > 10000))
            throw new IllegalArgumentException("");
        if(j1 <= j2)
            return false;

        while(k2 <= 10000) {
            k1 += j1;
            k2 += j2;
            if(k1 == k2) {
                return true;
            }
        }
        return false;
    }

    private static boolean invalidPosition(int k, int invalidRange) {
        return k < invalidRange;
    }
}
