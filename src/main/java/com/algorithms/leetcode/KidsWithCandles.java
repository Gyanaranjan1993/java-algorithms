package com.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandles {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>(candies.length);
        int max = 0;

        for (int i : candies){
            max = Math.max(max, i);
        }

        for (int candy : candies) {
            if (candy + extraCandies >= max)
                result.add(true);
            else result.add(false);
        }

        return result;
    }
}
