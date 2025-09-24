package com.algorithms.leetcode.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given an array, print the Next Greater Element (NGE) for every element.

The Next Greater Element for an element x is the first greater element on the right side of x in the array.

Elements for which no greater element exist, consider the next greater element as -1.

Examples
Example 1:

 Input: [4, 5, 2, 25]
 Output: [5, 25, 25, -1]
 Explanation: The NGE for 4 is 5, 5 is 25, 2 is 25, and there is no NGE for 25.
Example 1:

 Input: [13, 7, 6, 12]
 Output: [-1, 12, 12, -1]
 */
public class NextGreaterNumber {
    List<Integer> nextLargerElement(List<Integer> arr) {
        List<Integer> result = new ArrayList<>(arr.size());
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.size()-1; i>= 0;i--){
            if(stack.isEmpty()) {
                result.set(i , -1);
                stack.push(arr.get(i));
            } else {
                while (!stack.isEmpty() || stack.peek() <= arr.get(i)) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    result.set(i , -1);
                } else{
                    result.set(i, stack.peek());
                }
                stack.push(arr.get(i));
            }
        }
        return result;
    }
}
