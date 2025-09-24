package com.algorithms.leetcode.slidewindow;

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

    public static class MergeSortedArrays {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int midx = m - 1;
            int nidx = n - 1;
            int right = m + n - 1;

            while (nidx >= 0) {
                if (midx >= 0 && nums1[midx] > nums2[nidx]) {
                    nums1[right] = nums1[midx];
                    midx--;
                } else {
                    nums1[right] = nums2[nidx];
                    nidx--;
                }
                right--;
            }


        }
    }
}
