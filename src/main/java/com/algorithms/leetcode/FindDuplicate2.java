package com.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicate2 {

    /*
    My strategy is to keep track of the latest index at which each number appears, which I'll call index j.
    This index represents the closest position for that number from the current index.

    This approach works because we need to find duplicate numbers within a distance of k from the current index i,
    so the closer the previous index j is to the current index i, the more likely we are to find an answer.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> visitedMap = new HashMap<>();

        for (int i = 0; i < nums.length ; i++) {
            if(visitedMap.containsKey(nums[i]) && Math.abs(visitedMap.get(nums[i] - i)) <= k){
                return true;
            }
            visitedMap.put(nums[i], i);
        }

        return false;
    }
}
