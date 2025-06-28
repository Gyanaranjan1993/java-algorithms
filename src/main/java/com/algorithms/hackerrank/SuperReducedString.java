package com.algorithms.hackerrank;

import java.util.Stack;

public class SuperReducedString {
    public static String superReducedString(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length() ; i++){
            if(!stack.empty() && stack.peek() == s.charAt(i))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        if(stack.isEmpty())
            return "Empty String";

        for(char ch : stack){
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = superReducedString("aaabccddd");
        System.out.println(s);
    }
}
