package com.algorithms.leetcode.twopointers;

public class SquaringSortedArray {
    public int[] makeSquares(int[] arr) {
        int left = 0, right = arr.length - 1, resultIndex = arr.length - 1;
        int[] result = new int[arr.length];

        while(left <= right) {

            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if(leftSquare > rightSquare) {
                // If the square of the value at the left pointer is greater, store it in the squares array
                // at the current highestSquareIdx and move the left pointer to the right.
                result[resultIndex] = leftSquare;
                left++;
            } else {
                // If the square of the value at the right pointer is greater or equal, store it in the squares array
                // at the current highestSquareIdx and move the right pointer to the left.
                result[resultIndex] = rightSquare;
                right--;
            }
        }

        return result;
    }
}
