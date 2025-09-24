package com.algorithms.leetcode.slidewindow;

public class MaxConsecutiveOnes {
    public static int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int left = 0;
        int maxLength=0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) zeroCount++;

            // If number of zeros exceeds k, shrink the window from left
            while (zeroCount > k) {
                if(nums[left] == 0) zeroCount--;
                left++; //// shrink the window
            }
            // Update the max length of valid window
            maxLength = Math.max(maxLength, (right-left) + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }
}
