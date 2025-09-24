package com.algorithms.designpatterns.factory.solution;

public class OrderProcessor {
    public void processOrder(String orderType) {
        Order order = OrderFactory.createOrder(orderType);
        order.validate();
        order.process();
    }
}
