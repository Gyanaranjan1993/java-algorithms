package com.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {
    public static String solution() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CompletableFuture<String> result1 = CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "product";
                }, service)
                .exceptionally((throwable -> {
                    System.out.println("Error fetching product details");
                    return "Error";
                }));

        CompletableFuture<String> result2 = CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "price";
                }, service)
                .handle((r, ex) -> {
                    if (ex != null) {
                        System.out.println("Error fetching product details");
                        return "Error";
                    }
                    return r;
                });


        CompletableFuture<String> result3 = CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                        int a = 10/0;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "Success";
                }, service)
                .exceptionally(throwable -> {
                    System.out.println("Exception occurred:" + throwable.getMessage());
                    return "Failure";
                });

        CompletableFuture<String> result4 = result1
                .thenCombine(result2, (r1, r2) -> String.join(",", r1, r2))
                .thenCombine(result3, (r1, r2) -> String.join(",", r1, r2));

        result4.thenAccept(s -> System.out.println(s));

        try {
            return result4.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            service.shutdown();
        }
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}
