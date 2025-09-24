package com.algorithms.leetcode.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class DailyTempratures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for(int i = len - 1; i >= 0; i--){
            if(stack.isEmpty()) {
                result[i] = 0;
            }
            else {
                int count = 1;
                while(!stack.isEmpty() && stack.peek() <= temperatures[i]){
                    stack2.push(stack.pop());
                    count++;
                }
                if(stack.isEmpty()){
                    result[i] = 0;
                } else {
                    result[i] = count;
                }

                while (!stack2.isEmpty()) stack.push(stack2.pop());
            }
            stack.push(temperatures[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,40,50,60})));
    }
}
