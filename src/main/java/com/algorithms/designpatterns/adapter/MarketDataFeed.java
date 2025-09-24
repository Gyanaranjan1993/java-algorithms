package com.algorithms.designpatterns.adapter;

public interface MarketDataFeed {
    int fetchPrice(String stockSymbol);
}
