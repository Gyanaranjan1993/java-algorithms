package com.algorithms.leetcode.prefixsum;

/*
There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
The biker starts his trip on point 0 with altitude equal 0.

You are given an integer array gain of length n where gain[i] is the net gain in altitude between points
i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.



Example 1:

Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
Example 2:

Input: gain = [-4,-3,-2,-1,4,3,2]
Output: 0
Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
 */
public class HighestAltitude {
    public static int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int[] prefixSum = new int[gain.length + 1];
        prefixSum[0] = 0;

        for (int i = 0; i < gain.length; i++) {
            prefixSum[i+1] = prefixSum[i] + gain[i];
            maxAltitude = Math.max(prefixSum[i+1], maxAltitude);
        }

        return maxAltitude;
    }

    public int largestAltitude2(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0;

        for (int j : gain) {
            currentAltitude += j;
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{52,-91,72}));
    }
}
