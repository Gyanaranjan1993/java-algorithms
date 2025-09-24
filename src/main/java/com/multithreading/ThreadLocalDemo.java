package com.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {

    public static void main(String[] args) {
        Logger logger = new Logger();

        Runnable r1 = () -> {
            logger.setUser("Alice");
            for (int i =0; i < 10; i++) {
                logger.log();
            }
        };


        Runnable r2 = () -> {
            logger.setUser("Bob");
            for (int i =0; i < 10; i++) {
                logger.log();
            }
        };


        Runnable r3 = () -> {
            logger.setUser("Jack");
            for (int i =0; i < 10; i++) {
                logger.log();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(r1);
        executorService.submit(r2);
        executorService.submit(r3);

        executorService.shutdown();

    }

    static class Logger {
        private final ThreadLocal<String> threadLocal = new ThreadLocal<>();

        void setUser(String s){
            threadLocal.set(s);
        }

        void log(){
            System.out.println("logged by user: " + threadLocal.get());
        }
    }
}
