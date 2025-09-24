package com.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class OrderBook {
    private final Queue<Order> queue = new LinkedList<>();
    private final int MAX_SIZE = 5;

    public synchronized void submitOrder(Order order) throws InterruptedException {
        while (queue.size() == MAX_SIZE) {
            System.out.println(Thread.currentThread().getName() + "Order book full, producer waiting...");
            wait();
        }

        queue.add(order);
        System.out.println("Submitted: " + order);
        notify(); // Notify matcher
    }

    public  synchronized Order matchOrder() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + "Order book empty, matcher waiting...");
            wait();
        }

        Order order = queue.poll();
        System.out.println("Matched: " + order);

        notify(); // Notify producer
        return order;
    }
}
