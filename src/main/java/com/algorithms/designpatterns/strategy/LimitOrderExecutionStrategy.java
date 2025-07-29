package com.algorithms.designpatterns.strategy;

public class LimitOrderExecutionStrategy  implements ExecutionStrategy {
    @Override
    public void execute(String orderType, String orderDetails) {
        // Implementation for executing a limit order
        System.out.println("Executing limit order: " + orderType + " with details: " + orderDetails);
    }

}
