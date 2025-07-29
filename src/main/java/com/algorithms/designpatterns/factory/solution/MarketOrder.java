package com.algorithms.designpatterns.factory.solution;

public class MarketOrder implements Order {
    @Override
    public void process() {
        System.out.println("Processing market order...");
    }

    @Override
    public void validate() {
        System.out.println("Validating market order...");
    }

}
