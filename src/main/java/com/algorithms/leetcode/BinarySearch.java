package com.algorithms.leetcode;

/*
Given an array of integers nums which is sorted in ascending order, and an integer target,
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(mid == target)
                return mid;
            else if(target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int res = search(new int[]{-1,0,3,5,9,12}, 9);
    }
}
