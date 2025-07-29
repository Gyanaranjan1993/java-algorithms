package com.algorithms.designpatterns.factory.solution;

public class LimitOrder implements Order {
    @Override
    public void process() {
        System.out.println("Processing limit order...");
    }

    @Override
    public void validate() {
        System.out.println("Validating limit order...");
    }

}
