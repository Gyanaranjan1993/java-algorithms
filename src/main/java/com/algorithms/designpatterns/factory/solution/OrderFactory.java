package com.algorithms.designpatterns.factory.solution;

public class OrderFactory {
    public static Order createOrder(String orderType) {
        switch (orderType) {
            case "market":
                return new MarketOrder();
            case "limit":
                return new LimitOrder();
            case "stop":
                return new StopOrder();
            default:
                throw new IllegalArgumentException("Unknown order type");
        }
    }
}
