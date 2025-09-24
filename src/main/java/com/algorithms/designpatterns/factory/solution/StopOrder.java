package com.algorithms.designpatterns.factory.solution;

public class StopOrder implements Order {
    @Override
    public void process() {
        System.out.println("Processing stop order...");
    }

    @Override
    public void validate() {
        System.out.println("Validating stop order...");
    }

}
