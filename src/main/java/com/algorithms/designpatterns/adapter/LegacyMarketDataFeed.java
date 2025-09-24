package com.algorithms.designpatterns.adapter;

public class LegacyMarketDataFeed {
    public int fetchPrice(String stockSymbol){
        // Simulate fetching price from a legacy system
        System.out.println("Fetching price for " + stockSymbol + " from legacy market data feed.");
        return 100; // Returning a dummy price
    }
}
