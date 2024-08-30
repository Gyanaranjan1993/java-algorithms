package com.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
    and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.

    Example 1:

        Input: nums = [-1,0,1,2,-1,-4]`
        Output: [[-1,-1,2],[-1,0,1]]
        Explanation:
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].
        Notice that the order of the output and the order of the triplets does not matter.
   Example 2:

        Input: nums = [0,1,1]
        Output: []
        Explanation: The only possible triplet does not sum up to 0.
        Example 3:

        Input: nums = [0,0,0]
        Output: [[0,0,0]]
        Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSum {

    /*
        2 Pointer approach:

        As we have to navigate through 3 indices(i,j,k), we can keep one index constant and change the other 2 indices.

        We need to calculate the sum of the three indices that sums up to 0. There will be cases when the number
        won't sum up to zero, in that case we need to move the indices j & k.

        Now to determine which indices to move, we need to sort the array. So that if the sum is more than 1,
        then we know the lesser number lies towards the left of the array, therefore move back index K.

        Similarly, if the sum is less than 0, then we know that the greater number lies towards the right, so we move
        the left index (j).

        Also, as triplets can't contain be duplicates, so while shifting the indexes need to compare the current index
        value is same as the previous. If that's the case we move index further up.


     */
    static List<List<Integer>> threeSums(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {

            // if arr[i] == arr[i-1], so we skip to next number so that we don't have duplicate triplets.
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                int total = arr[i] + arr[j] + arr[k];
                if (total == 0) {
                    //If we found the triplet, then increment the j pointer, also check with the previous number,
                    //If they are same, move to the next pointer to avoid triplet duplicates.
                    result.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;

                    while (arr[j] == arr[j - 1] && j < k) {
                        j++;
                    }
                } else if (total < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = threeSums(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);
    }
}
