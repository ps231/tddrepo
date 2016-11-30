package com.tdd;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class ValidParenthesis {

    public static void main(final String[] args) {
        ValidParenthesis p = new ValidParenthesis();
        System.out.println("()[]{} " + p.isValid("()[]{}"));
        System.out.println("() " + p.isValid("()"));
        System.out.println("(()) " + p.isValid("(())"));
        System.out.println("(([{]})) " + p.isValid("(([{]}))"));
        System.out.println("([)] " + p.isValid("([)]"));
    }

    public boolean isValid(final String s) {
        final Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
              stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (!matchingParenthesisFound(stack, c)) {
                    throw new IllegalArgumentException("Invalid Parenthesis");
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean matchingParenthesisFound(final Stack<Character> stack, final char c) {
        if (stack.isEmpty())
            return false;
        final char parenthesisOnStack = stack.pop();
        switch (c) {
            case ')':
                return parenthesisOnStack == '(';
            case '}':
                return parenthesisOnStack == '{';
            case ']':
                return parenthesisOnStack == '[';
        }
        return false;
    }
}
