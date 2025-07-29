package com.algorithms.leetcode.arraysstring;

/*
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.



Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
 */
public class IncreasingTriplet {
    /*
    Initialize two variables, a and b, to INT_MAX.
Iterate through the array, and for each element:
If the element is less than or equal to a, update a with the element.
If the element is greater than a but less than or equal to b, update b with the element.
If the element is greater than both a and b, it means an increasing triplet is found, and the function returns true.
If the loop completes without finding an increasing triplet, return false.
     */
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= a) a = n;
            else if (n <= b) {
                b = n;
            } else {
                return true;
            }
        }

        return false;
    }
}
