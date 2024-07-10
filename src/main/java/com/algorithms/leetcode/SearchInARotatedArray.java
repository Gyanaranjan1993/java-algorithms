package com.algorithms.leetcode;

public class SearchInARotatedArray {

    /*
    We use modified binary search to find out the index of the target.

    1. We calculate the middle index of the array.
    2. Return middle index if the target is equal to value at middle index.
    3. Then check if the left part or the right part the array is sorted, because in sorted rotated array, any one part must be sorted.
    4. If value at left most index <= value at middle index , then we know that left part of the array sorted. Otherwise, right part is sorted.

    Case 1 (Left Part Sorted):
      1.  If the target lies between the leftMost index and the middle index, then we discard the right part of the array by setting the right most index to (midIndex - 1)
          Otherwise, we discard the left part of the array and check in the right array by setting the left most index to (midIndex + 1) .

    Case 2 (Right Part Sorted):
      If the target lies between the midIndex and the right most index, then we discard the left part of the array by setting the left most index to midIndex + 1.
      Otherwise, we discard the right part of the array by setting the right most index to (midIndex - 1) .

    The above steps are executed in a loop until the left most index is less than equal to right most index.



     */
    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }

        }

        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {40,5,10,20,30};
        System.out.println(search(arr, 20));
    }


}
