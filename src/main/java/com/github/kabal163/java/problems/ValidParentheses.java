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
        System.out.println("The sequence of '()[]{}}' is " + (isValid("()[]{}}") ? VALID : INVALID));
    }

    public static boolean isValid(String s) {
        int len = s.length();
        if (len == 1) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();

        for (char current : s.toCharArray()) {
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char lastOpen = stack.pop();
                if (lastOpen == '(' && current == ')') {
                    continue;
                }
                if (lastOpen == '{' && current == '}') {
                    continue;
                }
                if (lastOpen == '[' && current == ']') {
                    continue;
                }
                return false;
            }
        }

        return stack.isEmpty();
    }
}
