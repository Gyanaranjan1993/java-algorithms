package com.algorithms.designpatterns.factory.problem;

public class SaleOrder extends Order {
    @Override
    void processOrder() {
        System.out.println("Processing sale order...");
    }

    @Override
    void validateOrder() {
        System.out.println("Validating sale order...");
    }

}
