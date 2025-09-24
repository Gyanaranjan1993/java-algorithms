package com.multithreading.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FileWriter {
    private final Lock reentrantLock = new ReentrantLock();

    public void write(String message) {
        try {
            boolean acquired = reentrantLock.tryLock(5, TimeUnit.SECONDS);
            if (acquired) {
                System.out.println(Thread.currentThread().getName() + "->Writing message..." + message);
                Thread.sleep(2000);
            } else {
                System.out.println(Thread.currentThread().getName() + "->Can not acquire lock within 5 seconds.. skipping...");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        FileWriter writer = new FileWriter();
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                writer.write("test message-" + i);
            }

        };

        Thread t1 = new Thread(runnable, "Writer1");
        Thread t2 = new Thread(runnable, "Writer2");
        Thread t3 = new Thread(runnable, "Writer3");

        t1.start();
        t2.start();
        t3.start();
    }
}
