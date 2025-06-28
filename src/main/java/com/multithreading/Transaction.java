package com.multithreading;

import java.util.Random;
import java.util.concurrent.*;

class Transaction implements Callable<String> {
    private final String transactionId;
    private final double amount;

    public Transaction(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    @Override
    public String call() {
        try {
            System.out.println("Processing transaction: " + transactionId + " | Amount: $" + amount + " | Thread: " + Thread.currentThread().getName());
            Thread.sleep((long) (Math.random() * 2000)); // Simulate delay

            // Simulate random failure
            if (new Random().nextInt(10) < 2) { // 20% chance of failure
                throw new RuntimeException("Insufficient funds for " + transactionId);
            }

            return "Transaction " + transactionId + " SUCCESS";
        } catch (Exception e) {
            return "Transaction " + transactionId + " FAILED: " + e.getMessage();
        }
    }
}
