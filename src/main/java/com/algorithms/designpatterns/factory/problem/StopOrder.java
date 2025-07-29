package com.algorithms.designpatterns.factory.problem;

public class StopOrder extends Order {
    @Override
    void processOrder() {
        System.out.println("Processing stop order...");
    }

    @Override
    void validateOrder() {
        System.out.println("Validating stop order...");
    }

}
