package com.algorithms.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
You’re given an array of prices of a house over n years. You want to buy the house in one year and sell it in a later
year (i.e., buy before sell). Your goal is to calculate the minimum possible loss (i.e., buy_price - sell_price,
 where buy_price > sell_price), but only if the buy happens before the sell in the original list.
 */
public class MinimumLoss {
    /*
    Pair each price with its year: (price, index)

Sort the list in descending order by price

Traverse the list:

For each pair of consecutive prices: check if the buy year is before the sell year

If yes, update the minimum loss
     */

    public static long minimumLoss(long[] prices) {
        int n = prices.length;

        // Step 1: Pair prices with original indices
        Map<Long, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(prices[i], i);
        }

        // Step 2: Sort prices descending
        Arrays.sort(prices); // sort ascending
        long minLoss = Long.MAX_VALUE;

        // Step 3: Compare consecutive prices
        for (int i = n - 1; i > 0; i--) {
            long high = prices[i];
            long low = prices[i - 1];

            // Only if the more expensive price comes earlier in original array
            if (indexMap.get(high) < indexMap.get(low)) {
                minLoss = Math.min(minLoss, low - high);
            }
        }

        return minLoss;
    }
}
