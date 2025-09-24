package com.algorithms.designpatterns.abstractfactory;

public class LimitOrderFactory implements TradingFactory {

    @Override
    public Order createOrder(String type) {
        if ("limit".equalsIgnoreCase(type)) {
            return new LimitOrder();
        } else if ("stop".equalsIgnoreCase(type)) {
            return new StopOrder();
        }
        throw new IllegalArgumentException("Unknown order type: " + type);
    }

    @Override
    public void processOrder(Order order) {
        System.out.println("Processing limit order...");
    }

}
