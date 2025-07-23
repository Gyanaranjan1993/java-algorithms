package com.multithreading.trading;

enum OrderType { BUY, SELL }

public class Order {
    final String id;
    final OrderType type;
    double price;
    int quantity;
    final long timestamp;

    public Order(String id, OrderType type, double price, int quantity, long timestamp) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return type + " " + id + " $" + price + " x" + quantity;
    }
}
