package com.algorithms.designpatterns.abstractfactory;

public interface TradingFactory {
    Order createOrder(String type);  
    void processOrder(Order order);
}
