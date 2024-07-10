package com.algorithms.leetcode;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock.
 */
public class BuySellStock {

    public int maxProfit(int[] prices){
        int left = 0;
        int right= 1;
        int mx_p = 0;

        while(right < prices.length) {
            int c_p = prices[right] - prices[left];
            if(prices[left] < prices[right]){
                mx_p = Math.max(c_p, mx_p);
            } else {
                left = right;
            }
            right += 1;
        }

        return mx_p;
    }

    public int maxPrice3(int[] prices){
        int buyPrice = prices[0];
        int right = 1;
        int maxProfit = 0;


        while(right < prices.length) {
            if(prices[right] > buyPrice){
                maxProfit = Math.max(maxProfit, prices[right] - buyPrice);
            } else {
                buyPrice = prices[right];
            }
            right++;
        }
        return maxProfit;
    }
}
