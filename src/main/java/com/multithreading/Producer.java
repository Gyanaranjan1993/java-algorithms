package com.multithreading;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final int max;

    public Producer(BlockingQueue<Integer> queue, int max) {
        this.queue = queue;
        this.max = max;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < max; i++){
                System.out.println("Producing from thread:" + Thread.currentThread().getName());
                queue.put(i);
            }
            queue.put(-1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
