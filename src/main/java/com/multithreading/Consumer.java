package com.multithreading;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            int i = queue.poll();
            System.out.println("consumed: " + i);
            if(i == -1){
                System.out.println("Received poison pill, terminating");
                break;
            }
        }
    }
}
