package com.algorithms.designpatterns.factory.problem;

public class LimitOrder extends Order {
    @Override
    void processOrder() {
        System.out.println("Processing limit order...");
    }

    @Override
    void validateOrder() {
        System.out.println("Validating limit order...");
    }

}
