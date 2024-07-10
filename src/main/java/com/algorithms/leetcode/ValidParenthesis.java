package com.algorithms.leetcode;

import java.util.Stack;

public class ValidParenthesis {



    /*
    Best way ->>>
    The basic idea is to push the right parentheses ')', ']', or '}' into the stack each time when we encounter left ones.
    And if a right bracket appears in the string, we need check if the stack is empty and also whether the top element
    is the same with that right bracket.
    If not, the string is not a valid one. At last, we also need check if the stack is empty.
     */
    static  boolean isValid1(String s) {
        Stack<Character> stack = new Stack<Character>(); // create an empty stack
        for (char c : s.toCharArray()) {// loop through each character in the string
            if (c == '(') // if the character is an opening parenthesis
                stack.push(')'); // push the corresponding closing parenthesis onto the stack
            else if (c == '{') // if the character is an opening brace
                stack.push('}'); // push the corresponding closing brace onto the stack
            else if (c == '[') // if the character is an opening bracket
                stack.push(']'); // push the corresponding closing bracket onto the stack
            else if (stack.isEmpty() || stack.pop() != c) // if the character is a closing bracket
                // if the stack is empty (i.e., there is no matching opening bracket) or the top of the stack
                // does not match the closing bracket, the string is not valid, so return false
                return false;
        }
        // if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
        // so the string is valid, otherwise, there are unmatched opening brackets, so return false
        return stack.isEmpty();
    }

    /*
        Works but inefficient.
     */
    static public boolean isValid(String s) {

        int len = s.length();

        if (s.charAt(0) == '}' || s.charAt(0) == ')' || s.charAt(0) == ']')
            return false;

        if (s.charAt(len-1) == '{' || s.charAt(len-1) == '(' || s.charAt(len-1) == '[')
            return false;

        if (len % 2 != 0)
            return false;

        while (!s.isEmpty()) {
            if(!s.contains("{}") && !s.contains("()") && !s.contains("[]"))
                break;
            s = s.replace("{}", "").replace("()", "").replace("[]", "");
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid1("({[]})[]"));
    }
}
