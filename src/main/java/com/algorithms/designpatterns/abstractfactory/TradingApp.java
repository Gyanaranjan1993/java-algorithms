package com.algorithms.designpatterns.abstractfactory;

public class TradingApp {
    private TradingFactory tradingFactory;
    private Order order;

    public TradingApp(TradingFactory tradingFactory, String orderType) {
        this.tradingFactory = tradingFactory;
        this.order = tradingFactory.createOrder(orderType);
    }

    public void validateOrder() {
        order.validate();
    }

    public void placeOrder() {
        tradingFactory.processOrder(order);
    }

    public static void main(String[] args) {
        TradingFactory factory = new MarketOrderFactory();
        TradingApp app = new TradingApp(factory, "market");
        app.validateOrder();
        app.placeOrder();
    }

}
