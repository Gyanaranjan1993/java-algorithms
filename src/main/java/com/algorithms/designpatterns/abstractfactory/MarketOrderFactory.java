package com.algorithms.designpatterns.abstractfactory;

public class MarketOrderFactory implements TradingFactory {
    
    @Override
    public Order createOrder(String type) {
        if ("market".equalsIgnoreCase(type)) {
            return new MarketOrder();
        } else if ("stop".equalsIgnoreCase(type)) {
            return new StopOrder();
        }
        throw new IllegalArgumentException("Unknown order type: " + type);
    }

    @Override
    public void processOrder(Order order) {
        System.out.println("Processing market order...");
    }

}
