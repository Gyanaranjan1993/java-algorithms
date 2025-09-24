package com.algorithms.leetcode.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 */
public class MaxNumOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int count = 0;
        Arrays.sort(nums);
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum < k) left++;
            else if(sum > k) right --;
            else {
                count++;
                right--;
                left++;
            }
        }

        return count;
    }

    //TC - O(N), SC = O(N)
    public int maxOperationsUsingMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int neededKey = k - num;
            if (map.containsKey(neededKey)) {
                count++;
                map.put(neededKey, map.get(neededKey) - 1);
                if (map.get(neededKey) == 0) map.remove(neededKey);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
}
