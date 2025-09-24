package com.algorithms.leetcode.hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiffBetweenTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = new HashSet<>();
        Set<Integer> numSet2 = new HashSet<>();
        for (int n : nums1) numSet1.add(n);
        for (int n : nums2) numSet2.add(n);

        List<Integer> distinct1 = new ArrayList<>();
        List<Integer> distinct2 = new ArrayList<>();
        for (int n : numSet1) {
            if (!numSet2.contains(n)) distinct1.add(n);
        }

        for(int n : numSet2) {
            if (!numSet1.contains(n)) distinct2.add(n);
        }

        return List.of(distinct1, distinct2);
    }
}
