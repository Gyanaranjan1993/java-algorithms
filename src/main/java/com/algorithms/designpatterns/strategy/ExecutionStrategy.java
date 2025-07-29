package com.algorithms.designpatterns.strategy;

public interface ExecutionStrategy {
    void execute(String orderType, String orderDetails);
}
