package com.tdd.strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//https://leetcode.com/problems/longest-palindrome/?tab=Description
public class LongestPalindrome {

    public static void main(final String[] args) {
        LongestPalindrome p = new LongestPalindrome();
        System.out.println(p.longestPalindrome("abccccdd"));
        System.out.println(p.longestPalindrome("abc"));
        System.out.println(p.longestPalindrome("ccc"));
        System.out.println(p.longestPalindrome("abbba"));
        System.out.println(p.longestPalindrome("aaabaaaa"));
    }

    private int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int maxLength = 0;
        final Iterator<Map.Entry<Character, Integer>> iterator  = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (entry.getValue() > 1) {
                if (entry.getValue() % 2 == 0) {
                    maxLength += entry.getValue();
                    iterator.remove();
                } else {
                    maxLength += entry.getValue() - 1;
                    entry.setValue(1);
                }
            }
        }
        return map.isEmpty() ? maxLength : maxLength + 1;
    }
}
