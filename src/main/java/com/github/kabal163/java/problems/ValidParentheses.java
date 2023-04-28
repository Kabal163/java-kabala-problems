package com.github.kabal163.java.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    static final String VALID = "valid";
    static final String INVALID = "invalid";

    public static void main(String[] args) {
        System.out.println("The sequence of '[]' is " + (isValid("[]") ? VALID : INVALID));
        System.out.println("The sequence of '[{]}' is " + (isValid("[{]}") ? VALID : INVALID));
        System.out.println("The sequence of '()[]{}' is " + (isValid("()[]{}") ? VALID : INVALID));
    }

    public static boolean isValid(String s) {
        int len = s.length();
        if (len == 1) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
