package com.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TransactionWorkerWithFutures {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Callable<String>> transactionTasks = new ArrayList<>();
        transactionTasks.add(new Transaction("TXN1001", 250.00));
        transactionTasks.add(new Transaction("TXN1002", 430.75));
        transactionTasks.add(new Transaction("TXN1003", 129.50));
        transactionTasks.add(new Transaction("TXN1004", 980.00));
        transactionTasks.add(new Transaction("TXN1005", 75.25));
        transactionTasks.add(new Transaction("TXN1006", 640.00));

        try {
            List<Future<String>> results = executor.invokeAll(transactionTasks);

            for (Future<String> future : results) {
                try {
                    System.out.println(">>> " + future.get()); // Retrieve result
                } catch (ExecutionException e) {
                    System.out.println(">>> Task failed: " + e.getCause().getMessage());
                }
            }

        } catch (InterruptedException e) {
            System.out.println("Execution was interrupted.");
        } finally {
            executor.shutdown();
        }
    }
}

