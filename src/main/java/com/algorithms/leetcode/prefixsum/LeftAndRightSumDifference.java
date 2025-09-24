package com.algorithms.leetcode.prefixsum;

/*
Given an input array of integers nums, find an integer array, let's call it differenceArray, of the same length as an input integer array.

Each element of differenceArray, i.e., differenceArray[i], should be calculated as follows: take the sum of all elements to the left of index i in array nums (let's call it leftSumi), and subtract it from the sum of all elements to the right of index i in array nums (let's call it rightSumi), taking the absolute value of the result:

differenceArray[i] = | leftSumi - rightSumi |

If there are no elements to the left or right of i, the corresponding sum should be taken as 0.

Examples
Example 1:

Input: nums = [2, 5, 1, 6, 1]
Expected Output: [13, 6, 0, 7, 14]
Explanation:
For i=0: |(0) - (5+1+6+1)| = |0 - 13| = 13
For i=1: |(2) - (1+6+1)| = |2 - 8| = 6
For i=2: |(2+5) - (6+1)| = |7 - 7| = 0
For i=3: |(2+5+1) - (1)| = |8 - 1| = 7
For i=4: |(2+5+1+6) - (0)| = |14 - 0| = 14
 */
public class LeftAndRightSumDifference {
    public int[] findDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] differenceArray = new int[n];
        int leftSum = nums[0], totalSum = 0;
        for(int num : nums) totalSum += num;

        for(int i = 0; i < n ; i++) {
            if(i == 0 || i == n-1)
                differenceArray[i] = Math.abs(totalSum - nums[i]);
            else {
                differenceArray[i] = Math.abs(leftSum - (totalSum - nums[i] - leftSum));
                leftSum += nums[i];
            }
        }
        return differenceArray;
    }

    public int[] findDifferenceArray2(int[] nums) {
        int n = nums.length;
        int[] differenceArray = new int[n];
        int leftSum = nums[0], rightSum = 0;
        for(int num : nums) rightSum += num;

        for(int i = 0; i < n ; i++) {
            rightSum = rightSum - nums[i];
            differenceArray[i] = Math.abs(rightSum - leftSum);
            leftSum += nums[i];
        }
        return differenceArray;
    }

}
