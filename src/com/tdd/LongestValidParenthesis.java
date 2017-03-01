package com.tdd;

import java.util.Stack;

//given a sequence of parenthesis, find the longest valid sequence
//()()(()))(() - length = 8
//()())(()(()) - length = 6
//)()()) - length = 2
//https://leetcode.com/problems/longest-valid-parentheses
public class LongestValidParenthesis {
    public static void main(final String... args) {
//        System.out.println(LongestValidParenthesis.longestSequence("()()()"));
        System.out.println(LongestValidParenthesis.longestSequence("()((())"));
        System.out.println(LongestValidParenthesis.longestSequence("(()"));
        System.out.println(LongestValidParenthesis.longestSequence("())"));
        System.out.println(LongestValidParenthesis.longestSequence("(()))()"));
//        System.out.println(LongestValidParenthesis.longestSequence("()()((()))(()"));
//        System.out.println(LongestValidParenthesis.longestSequence(")()())"));
    }

    public static int longestSequence(final String sequence) {

        final Stack<Integer> parIndex = new Stack<>();
        int longestSeq = Integer.MIN_VALUE;

        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == '(')
                parIndex.push(i);
            else if (sequence.charAt(i) == ')') {
                if (!parIndex.empty()) {
                    final int startIndex = parIndex.pop();

                    if (parIndex.empty() || i == sequence.length() - 1) {
                        longestSeq = Math.max(longestSeq, i - startIndex + 1);
                    }
                }
            }
        }
        return longestSeq;
    }
}
