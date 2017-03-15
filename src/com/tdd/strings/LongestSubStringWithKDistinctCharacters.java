package com.tdd.strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestSubStringWithKDistinctCharacters {

    public static void main(final String... args) {

        System.out.println(longestSubString("abcbbbbcccbdddadacb", 2));
        System.out.println(longestSubString("abcbbcccddad", 2));
        System.out.println(longestSubString("abcbbcccddadddad", 2));
        System.out.println(longestSubString("aaabbbbbbbcbbcccddad", 2));
    }

    private static int longestSubString(final String sequence, final int charCount) {
        int length = Integer.MIN_VALUE;

        int leftIndex = 0;

        final Map<Character, Integer> map = new HashMap<Character, Integer>();
        final Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < sequence.length(); i++) {
            final char c = sequence.charAt(i);

            if (queue.size() != charCount) {
                if (!queue.contains(c))
                    queue.add(c);
                map.put(c, i);
            } else if (queue.size() == charCount && queue.contains(c)) {
                map.put(c, i);
            } else {
                // queue is full and we have a distinct char
                length = Math.max(length, i - leftIndex);
                leftIndex = map.get(queue.peek()) + 1;
                map.remove(queue.peek());
                queue.poll();
                queue.add(c);
                map.put(c, i);
            }
        }

        length = Math.max(length, sequence.length() - leftIndex);
        return length;
    }
}
