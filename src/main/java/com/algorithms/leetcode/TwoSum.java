package com.algorithms.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class TwoSum {

    //o(n^2)

    /**
     * Bruteforce java code
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }

        return null;
    }

    //o(n)

    /**
     * creates a hashMap, checks if hashmap contains (target - value at current index)
     * If yes, returns hashmap.get(target - value at current index), index of current value
     * If not, hashMap.put(value at current index, index of current value)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumUsingHashMap(int[] nums, int target) {

        Map<Integer, Integer> numbersMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int diff = target - nums[i];
            if (numbersMap.containsKey(diff)) {
                return new int[]{numbersMap.get(diff), i};
            } else {
                numbersMap.put(nums[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {

        int[] input = new int[]{5, 6, 7, 8};
        int[] result = new TwoSum().twoSum(input, 11);

        System.out.println(Arrays.toString(result));

        int[] result_2 = new TwoSum().twoSumUsingHashMap(input, 15);

        System.out.println(Arrays.toString(result_2));
    }
}
