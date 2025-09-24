package com.algorithms.designpatterns.factory.problem;

// Breaking SRP by responsible to create order and process it
// This class should only be responsible for processing orders, not creating them
// This is a violation of the Single Responsibility Principle (SRP)
// This can be fixed using Factory Method or Abstract Factory pattern
public class OrderProcessor {
    public void process(Order order, String orderType) {
        switch (orderType) {
            case "market":
                order = new MarketOrder();
                break;

            case "limit":
                order = new LimitOrder();
                break;

            case "sale":
                order = new SaleOrder();
                break;
            case "stop":
                order = new StopOrder();
                break;
            default:
                break;
        }
        order.validateOrder();
        order.processOrder();
    }
}
