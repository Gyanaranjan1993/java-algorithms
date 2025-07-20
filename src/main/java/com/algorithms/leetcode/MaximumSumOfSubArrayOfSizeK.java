package com.algorithms.leetcode;

/**
 * Given an array of positive numbers and a positive number 'k,' find the maximum sum of any contiguous subarray of size 'k'.
 *
 * Example 1:
 *
 * Input: arr = [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 */
public class MaximumSumOfSubArrayOfSizeK {
    public int findMaxSumSubArray(int k, int[] arr) {
        // TODO: Write your code here
        int max = 0, sum = 0;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++ ) {
            sum += arr[windowEnd];

            if(windowEnd >= k - 1) {
                max = Math.max(max, sum);
                sum -= arr[windowStart];
                windowStart++;
            }
        }
        return max;
    }

}
