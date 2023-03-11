package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BracketChecker {
  
    public String getValidBrackets(String s) {
        long count = 0L;
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder(s);

        for (int i = 0; i < result.length(); i++) {
            char currentCharacter = result.charAt(i);
            if (currentCharacter == '(') {
                stack.push(i);
            } else if (!stack.isEmpty() && result.charAt(stack.peek()) == '(') {
                stack.pop();
                count += 2;
            } else {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            result.deleteCharAt(index);
        }

        return count > 0 ? result.insert(0, (count) + "-").toString() : "0";
    }
}
