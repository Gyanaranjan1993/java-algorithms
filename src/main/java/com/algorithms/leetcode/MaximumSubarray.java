package com.algorithms.leetcode;

/*
    Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */
public class MaximumSubarray {

    /*
        Kaden's algorithm:

        We need to return the maximum sum of the numbers in the array.
        We can loop through each element and calculate the sum and store it in a temp
        max value.

        if at any point Current sum is greater than max sum, then we assign mx sum to current sum
        In any situation CS becomes negative, we make the current sum to 0. In this way, it discards
        that sub array and we start fresh from the next section of the array
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int currSum = 0;

        for (int i : nums) {
            currSum = currSum + i;
            if(sum < currSum)
                sum = currSum;
            if(currSum < 0)
                currSum = 0;
        }

        return sum;

    }




}
