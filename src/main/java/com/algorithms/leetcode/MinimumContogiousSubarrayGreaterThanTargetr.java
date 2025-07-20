package com.algorithms.leetcode;

public class MinimumContogiousSubarrayGreaterThanTargetr {
    public int findMinSubArray(int S, int[] arr) {
        int minLength = Integer.MAX_VALUE;
        int ws = 0;
        int sum = 0;

        for (int we = 0; we < arr.length; we++) {
            sum += arr[we];
            while (sum >= S) {
                minLength = Math.min(minLength, we - ws + 1);
                sum -= arr[ws];
                ws++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
