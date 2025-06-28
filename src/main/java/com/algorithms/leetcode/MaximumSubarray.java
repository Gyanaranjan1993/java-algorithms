package com.algorithms.leetcode;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i : nums){

            //if at any point the current subarray becomes negative, then we can say the the array we
            //have traversed so far is not helping to produce the max value. So we discard that part by making
            //the current sum as zero.
            if (currSum < 0)
                 currSum = 0;
            currSum += i;
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}
