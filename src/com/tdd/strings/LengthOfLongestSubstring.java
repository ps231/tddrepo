package com.tdd.strings;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LengthOfLongestSubstring {

    public static  void main(final String... args) {
        LengthOfLongestSubstring s = new LengthOfLongestSubstring();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(final String s) {

        final Map<Character, Integer> existingCharacters = new HashMap<Character, Integer>();
        int maxLength = 0;

        for (int start = 0, end = 0; end < s.length(); end++) {
            if (existingCharacters.containsKey(s.charAt(end))) {
                start = Math.max(start, existingCharacters.get(s.charAt(end)) + 1);
            }
            existingCharacters.put(s.charAt(end), end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
