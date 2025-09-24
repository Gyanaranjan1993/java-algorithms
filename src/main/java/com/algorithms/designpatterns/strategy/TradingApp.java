package com.algorithms.designpatterns.strategy;

public class TradingApp {
    public static void main(String[] args) {
        OrderService orderService = new OrderService(new MarketOrderExecutionStrategy());
        orderService.placeOrder("market", "Buy 100 shares of XYZ at market price");


        orderService.setExecutionStrategy(new LimitOrderExecutionStrategy());
        orderService.placeOrder("limit", "Buy 50 shares of ABC at $100 limit");

        orderService.setExecutionStrategy(new StopOrderExecutionStrategy());
        orderService.placeOrder("stop", "Sell 30 shares of DEF at $90 stop price");
    }
}
