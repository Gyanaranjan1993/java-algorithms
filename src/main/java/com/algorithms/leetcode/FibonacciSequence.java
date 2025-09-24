package com.algorithms.leetcode;

import java.util.Arrays;

public class FibonacciSequence {

    // time complexity - O(2^n)
    // space complexity - O(n)
    public static int fibonacciRecursive(int n) {
        System.out.println("Calculating at position: " + n);
        if (n <= 1) {
            return n;
        }

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }


    // time c - O(n)
    // space - (n)
    static int fibonacciUsingDynamicProgramming(int n, int[] memo) {

        if (n <= 1)
            return n;

        if (memo[n] != -1)
            return memo[n];

        memo[n] = fibonacciUsingDynamicProgramming(n - 1, memo) + fibonacciUsingDynamicProgramming(n - 2, memo);

        return memo[n];
    }

    // time com - o(n)
    // space - o(1) due to the same variable being reused
    static int fibonacciUsingIterative(int n) {
        if (n <= 1)
            return n;

        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }


    public static void main(String[] args) {
        int n = 4;

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        int num = fibonacciUsingDynamicProgramming(n, memo);
    }


}
