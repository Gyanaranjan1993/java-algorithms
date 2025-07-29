package com.algorithms.designpatterns.factory.problem;

public class MarketOrder extends Order {
    @Override
    void processOrder() {
        System.out.println("Processing market order...");
    }

    @Override
    void validateOrder() {
        System.out.println("Validating market order...");
    }

}
