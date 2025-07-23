package com.algorithms.leetcode.stackqueue;

import java.util.Stack;

public class ReverseStringUsingStack {
    public String reverseString(String s) {
        // ToDo: Write Your Code Here.
        Stack<Character> chars = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray())
            chars.push(ch);

        while(chars.isEmpty()) sb.append(chars.pop());

        return sb.toString();
    }
}
