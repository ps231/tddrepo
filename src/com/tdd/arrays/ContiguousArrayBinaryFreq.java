package com.tdd.arrays;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/contiguous-array/#/description
public class ContiguousArrayBinaryFreq {

    public static void main(final String[] args) {

        System.out.println(findMaxLength(new int[] {}));
        System.out.println(findMaxLength(new int[] {1}));
        System.out.println(findMaxLength(new int[] {0,1,1,0}));
        System.out.println(findMaxLength(new int[] {0,1,1,0,0,1,0,0,1}));
        System.out.println(findMaxLength(new int[] {0,1,1,0,1,1,1,0}));
    }

    static int findMaxLength(int[] nums) {
        final Map<Integer, Integer> binaryFreqMap = new HashMap<>();

        for(int num : nums) {
            if(binaryFreqMap.get(num) == null)
                binaryFreqMap.put(num, 1);
            else
                binaryFreqMap.put(num, binaryFreqMap.get(num) + 1);
        }

        if(binaryFreqMap.isEmpty())
            return 0;
        if(binaryFreqMap.keySet().size() == 1)
            return 0;
        if(binaryFreqMap.keySet().size() > 2)
            throw new IllegalArgumentException("Expected only 0 and 1");
        int zeroFreq = binaryFreqMap.get(0);
        int oneFreq = binaryFreqMap.get(1);

        return zeroFreq <= oneFreq ? zeroFreq * 2 : oneFreq * 2;

    }
}
