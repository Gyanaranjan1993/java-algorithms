package com.algorithms.leetcode.twopointers;

/*
    Given an array of sorted numbers, move all non-duplicate number instances at the beginning of the array in-place.
    The non-duplicate numbers should be sorted and you should not use any extra space so that the solution has constant
    space complexity i.e., . Move all the unique number instances at the beginning of the array and after moving return
    the length of the subarray that has no duplicate in it.
 */
public class NextNonDuplicate {
    public int moveElements(int[] arr) {
        int nextNonDuplicate = 1; // Initialize the index of the next non-duplicate element

        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Check if the current element is different from the previous non-duplicate element
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                // If different, copy the current element to the nextNonDuplicate position
                arr[nextNonDuplicate] = arr[i];
                // Increment the index of the next non-duplicate element
                nextNonDuplicate++;
            }
        }

        // Return the length of the modified array (number of non-duplicate elements)
        return nextNonDuplicate;
    }
}
