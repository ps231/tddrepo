package com.tdd.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/first-unique-character-in-a-string
public class FirstUniqueCharIndexInAString {

    public static void main(final String[] args) {
        System.out.println("abcbd, first unique index at: " + findUniqueCharIndex("abcbd"));
        System.out.println("abcacd, first unique index at: " + findUniqueCharIndex("abcacd"));
        System.out.println("abcacabd, first unique index at: " + findUniqueCharIndex("abcacabd"));
        System.out.println("abcacabdd, first unique index at: " + findUniqueCharIndex("abcacabdd"));
    }

    private static int findUniqueCharIndex(final String str) {
        final Map<Character, Integer> uniqueMap = new LinkedHashMap<>();
        final Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!uniqueMap.containsKey(c) && !map.containsKey(c)) {
                uniqueMap.put(c, i);
            } else {
                uniqueMap.remove(c);
                map.put(c, i);
            }
        }

        if (!uniqueMap.isEmpty()) {
            for (Map.Entry<Character, Integer> entry : uniqueMap.entrySet()) {
                return entry.getValue();
            }
        } else
            return -1;

        return -1;
    }
}
