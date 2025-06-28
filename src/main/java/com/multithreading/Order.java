package com.multithreading;

public class Order {
    String type; // "BUY" or "SELL"
    double price;
    int quantity;

    public Order(String type, double price, int quantity) {
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return type + " " + quantity + " @ $" + price;
    }
}
