package com.algorithms.leetcode.twopointers;

public class ContainerWithMostWater {

    /*
        > The widest container (using first and last line) is a good candidate, because of its width.
        Its water level is the height of the smaller one of first and last line.

        > All other containers are less wide and thus would need a higher water level in order to
        hold more water.
        > The smaller one of first and last line doesn't support a higher water level and
        can thus be safely removed from further consideration.
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int breadth = right - left;
            int length = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, (breadth * length));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,1}));
    }
}
