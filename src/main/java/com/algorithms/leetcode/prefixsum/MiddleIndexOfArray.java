package com.algorithms.leetcode.prefixsum;

/*
Given an integer array nums, return the leftmost middleIndex (i.e., the smallest amongst all the possible ones).

A middleIndex is an index where the sum of the numbers to the left of this index is equal to the sum of the numbers to the right of this index.

You can consider the left sum 0 for middleIndex == 0, and right sum 0 for middleIndex == nums.length - 1.

If no middleIndex exists in nums, return -1.

Examples
Example 1:
Input: nums = [1, 7, 3, 6, 5, 6]
Expected Output: 3
Justification: The sum of the numbers to the left of index 3 (1 + 7 + 3 = 11) is equal to the sum of the numbers to the right of index 3 (5 + 6 = 11).
Example 2:
Input: nums = [2, 1, -1]
Expected Output: 0
Justification: The sum of the numbers to the left of index 0 is considered to be 0. The sum of the numbers
to the right of index 0 (1 + -1 = 0) is also 0.
Example 3:
 */
public class MiddleIndexOfArray {
    public int findMiddleIndex(int[] nums) {
        // Calculate the total sum of all elements in the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Initialize the sum of elements to the left
        int leftSum = 0;

        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the sum of elements to the right
            int rightSum = totalSum - leftSum - nums[i];
            // Check if the sum of elements to the left equals the sum of elements to the right
            if (leftSum == rightSum) {
                return i; // Return the index if found
            }
            // Update the sum of elements to the left
            leftSum += nums[i];
        }
        return -1; // Return -1 if no such index is found
    }
}
