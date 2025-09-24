package com.algorithms.designpatterns.strategy;

public class MarketOrderExecutionStrategy implements ExecutionStrategy {
    @Override
    public void execute(String orderType, String orderDetails) {
        // Implementation for executing a market order
        System.out.println("Executing market order: " + orderType + " with details: " + orderDetails);
    }

}
