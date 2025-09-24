package com.multithreading;

import java.util.concurrent.CountDownLatch;

public class Service implements Runnable {
    private final String serviceName;
    private final int initializationTime;
    private final CountDownLatch latch;

    public Service(String serviceName, int initializationTime, CountDownLatch latch) {
        this.serviceName = serviceName;
        this.initializationTime = initializationTime;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(serviceName + " is initializing...");
            Thread.sleep(initializationTime);
            System.out.println(serviceName + " has initialized.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown(); // Decrement the count of the latch
        }
    }
}
