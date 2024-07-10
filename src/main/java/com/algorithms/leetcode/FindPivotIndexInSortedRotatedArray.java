package com.algorithms.leetcode;

public class FindPivotIndexInSortedRotatedArray {

    /*
      Find pivot index using binary search

      1. Find the midIndex.
      2. If value at midIndex > value at midIndex+1, then midIndex+1 is the index of pivot
      3. Else if value at midIndex-1 > value at midIndex, then midIndex is index of pivot.
      4. else if value at leftIndex is less than value at midIndex, then the pivot must lie in the second half of the array.
      5. else if value at leftIndex > value at midIndex, then the pivot must lie in the first half of the array.

     */

    private static int findPivot(int[] arr, int left, int right){
        if(left > right){
            return -1;
        }

        if(right == left){
            return left;
        }

        int mid = (left + right) / 2;
        if (arr[mid] > arr[mid + 1]){
            return mid + 1;
        } else if(arr[mid-1] > arr[mid]){
            return mid;
        } else if(arr[left] < arr[mid]){
            return findPivot(arr, mid+1, right);
        } else{
            return findPivot(arr, left, mid-1);
        }
    }

    private int findPivot(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        int pivotIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // If mid is larger than the last element, then we know that the pivot must be in the right part.
            // Else if mid is less than the last element then we can discard the right part of the array;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
                pivotIndex = mid;
            } else {
                right = mid - 1;
            }
        }
        return pivotIndex;
    }
}
