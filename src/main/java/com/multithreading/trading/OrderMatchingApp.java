package com.multithreading.trading;

import java.util.Random;
import java.util.concurrent.*;

public class OrderMatchingApp {

    public static void main(String[] args) throws InterruptedException {
        OrderMatchingEngine engine = new OrderMatchingEngine();
        BlockingQueue<Order> queue = new LinkedBlockingQueue<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Start order processor thread
        Thread processorThread = new Thread(() -> {
            try {
                while (true) {
                    Order order = queue.take(); // blocking call
                    engine.addOrder(order);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        processorThread.start();

        // Simulate 20 random order submissions from multiple threads
        for (int i = 1; i <= 20; i++) {
            final int id = i;
            executor.submit(() -> {
                Random rand = new Random();
                OrderType type = rand.nextBoolean() ? OrderType.BUY : OrderType.SELL;
                double price = 100 + rand.nextInt(10); // $100 - $109
                int qty = 1 + rand.nextInt(5);
                Order order = new Order("O" + id, type, price, qty, System.nanoTime());
                queue.offer(order);
                System.out.println("📥 Submitted: " + order);
            });
        }

        // Shutdown after a delay
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
}
