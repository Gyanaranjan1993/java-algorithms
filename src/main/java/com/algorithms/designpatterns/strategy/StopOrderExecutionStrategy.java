package com.algorithms.designpatterns.strategy;

public class StopOrderExecutionStrategy implements ExecutionStrategy {
    @Override
    public void execute(String orderType, String orderDetails) {
        // Implementation for executing a stop order
        System.out.println("Executing stop order: " + orderType + " with details: " + orderDetails);
    }

}
