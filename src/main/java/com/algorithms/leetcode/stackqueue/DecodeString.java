package com.algorithms.leetcode.stackqueue;

import java.util.Stack;

/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
 */
public class DecodeString {
    /*
    🔹 High-Level Plan
        We use two stacks:

        countStack: stores repeat counts (3, 2, etc.)

        stringStack: stores the strings built before entering brackets

        We also use:

        current: a StringBuilder to hold the current characters

        k: to build up any multi-digit numbers

        🔹 Step-by-Step Execution
        Initial State:
        countStack = []

        stringStack = []

        current = ""

        k = 0

        ➤ Char = '3'
        Digit → build number: k = 3

        ➤ Char = '['
        Push k = 3 to countStack → [3]

        Push current = "" to stringStack → [""]

        Reset k = 0, current = ""

        ➤ Char = 'a'
        Append to current → current = "a"

        ➤ Char = '2'
        Digit → build number: k = 2

        ➤ Char = '['
        Push k = 2 to countStack → [3, 2]

        Push current = "a" to stringStack → ["", "a"]

        Reset k = 0, current = ""

        ➤ Char = 'c'
        Append to current → current = "c"

        ➤ Char = ']'
        Pop count = 2 from countStack → [3]

        Pop prev = "a" from stringStack → [""]

        Append "c" repeated 2 times → "cc"

        Merge with prev: current = "a" + "cc" = "acc"

        ➤ Char = ']'
        Pop count = 3 from countStack → []

        Pop prev = "" from stringStack → []

        Append "acc" repeated 3 times → "accaccacc"

        Merge with prev: current = "" + "accaccacc"
     */
    public String decodeString(String s) {
        int k = 0;
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder decoded = new StringBuilder();
        StringBuilder current = new StringBuilder();
        for(char ch: s.toCharArray()) {
            if(Character.isDigit(ch)){
                k = k *10 + (ch - '0');
            } else if(ch == '[') {
                countStack.push(k);
                k = 0;
                stringStack.push(current);
                current = new StringBuilder();
            } else if(ch == ']') {
                int count = countStack.pop();
                decoded = stringStack.pop();
                while(count > 0 ){
                    decoded.append(current);
                    count--;
                }
                current = decoded;
            } else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}
