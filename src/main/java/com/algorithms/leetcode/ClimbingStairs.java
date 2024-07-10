package com.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    /*
        Using recursion.

        We can use two ways to reach to nth step. Either take 2 steps from (n-2) or 1 step from (n-1)
        so number of ways for nth step = no of ways for (n-1) + no of ways for (n-2)
     */
    public int climbStairs(int n) {

        if(n == 1 || n == 0)
            return 1;

        return climbStairs(n-1) + climbStairs(n-2);

    }

    /*
        Optimization using Memoization.

        Basically create a map and store the number of ways to reach a particular step.
        If we find the value for a step in the map, then just return that
        or else, calculate the no of ways for the step and add it to the map for future reference.
     */

    public int climbStairs2(int n){
        Map<Integer, Integer> memoMap = new HashMap<>();
        return climbStairsUsingMemo(n, memoMap);
    }

    private int climbStairsUsingMemo(int n, Map<Integer, Integer> memoMap) {
        if(n == 1 || n == 0)
            return 1;

        if(!memoMap.containsKey(n)){
            memoMap.put(n, climbStairsUsingMemo(n-1, memoMap) + climbStairsUsingMemo(n-2, memoMap));
        }

        return memoMap.get(n);
    }
}
