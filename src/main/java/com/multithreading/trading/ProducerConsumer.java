package com.multithreading.trading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {
    public static void main(String[] args) {
        Worker worker = new Worker(new ArrayBlockingQueue<>(1));

        Runnable r1;
        r1 = new Runnable() {
            ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> Thread.currentThread().getName());
            @Override
            public void run() {
                while (true) {
                    System.out.println("Producing from:"+ threadLocal.get());
                    worker.produce();
                }

            }
        };

        Runnable r2 = () -> {
            while (true) {
                worker.consume();
            }

        };

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(r1);
        service.submit(r2);


    }

    static class Worker {
        private final BlockingQueue<String> queue;
        private final Object lock = new Object();

        public Worker(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        synchronized void produce() {
                while (queue.size() == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                queue.offer("Published Message...");
                notify();
            }

        synchronized void consume() {
                while (queue.isEmpty()){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                synchronized (lock) {
                    System.out.println("Consumed: " + queue.poll());
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                notify();
        }
    }
}
