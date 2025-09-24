package com.multithreading;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FactorialCalculator {
    private final ConcurrentHashMap<Integer, Long> factorialCache = new ConcurrentHashMap<>();

    public long getFactorial(int n) {
        factorialCache.computeIfAbsent(n, this::calculateFactorial);
        return factorialCache.get(n);
    }

    private synchronized long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;

    }

    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator();
        FactorialWorker factorialWorker1 = new FactorialWorker(calculator, new int[]{10,334,55434,3333,33333,4444,3333});
        FactorialWorker factorialWorker2 = new FactorialWorker(calculator, new int[]{10,334,554534,35656333,33333,44445, 66633});

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(factorialWorker1);
        executorService.submit(factorialWorker2);
    }

}