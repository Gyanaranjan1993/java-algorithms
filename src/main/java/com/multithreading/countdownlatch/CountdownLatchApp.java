package com.multithreading.countdownlatch;

import com.multithreading.Service;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchApp {

        public static void main(String[] args) {
            int numberOfServices = 3;
            CountDownLatch latch = new CountDownLatch(numberOfServices);

            // Initialize services
            new Thread(new Service("AuthenticationService", 3000, latch)).start();
            new Thread(new Service("DataProcessingService", 4000, latch)).start();
            new Thread(new Service("LoggingService", 2000, latch)).start();

            // Main application thread waiting for services to initialize
            try {
                latch.await();
                System.out.println("All services are initialized. Starting main application...");
                // Proceed with main application logic
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
