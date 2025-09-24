package com.multithreading.trading;

import java.util.PriorityQueue;

public class OrderMatchingEngine {

    private final PriorityQueue<Order> buyOrders = new PriorityQueue<>(
            (a, b) -> a.price == b.price ? Long.compare(a.timestamp, b.timestamp) : Double.compare(b.price, a.price)
    );

    private final PriorityQueue<Order> sellOrders = new PriorityQueue<>(
            (a, b) -> a.price == b.price ? Long.compare(a.timestamp, b.timestamp) : Double.compare(a.price, b.price)
    );

    public synchronized void addOrder(Order order) {
        if (order.type == OrderType.BUY) {
            matchBuyOrder(order);
        } else {
            matchSellOrder(order);
        }
    }

    private void matchBuyOrder(Order buy) {
        while (!sellOrders.isEmpty() && buy.quantity > 0 && sellOrders.peek().price <= buy.price) {
            Order sell = sellOrders.poll();
            int matchedQty = Math.min(buy.quantity, sell.quantity);
            System.out.println("✅ Matched BUY " + buy.id + " with SELL " + sell.id + " for qty " + matchedQty);

            buy.quantity -= matchedQty;
            sell.quantity -= matchedQty;

            if (sell.quantity > 0) sellOrders.add(sell);
        }
        if (buy.quantity > 0) buyOrders.add(buy);
    }

    private void matchSellOrder(Order sell) {
        while (!buyOrders.isEmpty() && sell.quantity > 0 && buyOrders.peek().price >= sell.price) {
            Order buy = buyOrders.poll();
            int matchedQty = Math.min(sell.quantity, buy.quantity);
            System.out.println("✅ Matched SELL " + sell.id + " with BUY " + buy.id + " for qty " + matchedQty);

            sell.quantity -= matchedQty;
            buy.quantity -= matchedQty;

            if (buy.quantity > 0) buyOrders.add(buy);
        }
        if (sell.quantity > 0) sellOrders.add(sell);
    }
}
