package com.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        executorService.submit(new Producer(queue, 100));
        executorService.submit(new Consumer(queue));

        executorService.shutdown();
    }
}
