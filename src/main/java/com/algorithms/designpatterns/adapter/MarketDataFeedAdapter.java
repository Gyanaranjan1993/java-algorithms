package com.algorithms.designpatterns.adapter;

// Uses Adapter design pattern to adapt LegacyMarketDataFeed to MarketDataFeed interface
// which clients can use without knowing about the legacy system.
public class MarketDataFeedAdapter implements MarketDataFeed {
    private LegacyMarketDataFeed legacyMarketDataFeed;

    public MarketDataFeedAdapter(LegacyMarketDataFeed legacyMarketDataFeed) {
        this.legacyMarketDataFeed = legacyMarketDataFeed;


        
    }

    @Override
    public int fetchPrice(String stockSymbol) {
        // Delegate the call to the legacy system
        return legacyMarketDataFeed.fetchPrice(stockSymbol);
    }

}
