package com.multithreading;

import java.util.Random;

public class TradingEngine {
    public static void main(String[] args) {
        OrderBook orderBook = new OrderBook();

        Runnable producer = () -> {
            Random random = new Random();
            String[] types = {"BUY", "SELL"};

            for (int i = 0; i < 10; i++) {
                try {
                    String type = types[random.nextInt(2)];
                    double price = 100 + random.nextInt(50);
                    int quantity = 1 + random.nextInt(10);
                    Order order = new Order(type, price, quantity);
                    orderBook.submitOrder(order);
                    Thread.sleep(700);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        };

        Runnable matcher = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    orderBook.matchOrder();
                    Thread.sleep(100);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        };

        new Thread(producer).start();
        new Thread(matcher).start();
    }
}
