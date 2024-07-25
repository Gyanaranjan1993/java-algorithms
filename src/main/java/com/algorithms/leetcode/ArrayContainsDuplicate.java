package com.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
    Given an integer array nums,
    return true if any value appears at least twice in the array,
    and return false if every element is distinct.
 */
public class ArrayContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for(int n : nums){
            if(numSet.contains(n))
                return true;
            numSet.add(n);
        }

        return false;
    }
}
