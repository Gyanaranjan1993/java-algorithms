package com.algorithms.designpatterns.strategy;

public class OrderService {
    private ExecutionStrategy executionStrategy;

    public OrderService(ExecutionStrategy executionStrategy) {
        this.executionStrategy = executionStrategy;
    }

    public void placeOrder(String orderType, String orderDetails) {
        executionStrategy.execute(orderType, orderDetails);
    }

    void setExecutionStrategy(ExecutionStrategy executionStrategy) {
        this.executionStrategy = executionStrategy;
    }
}
