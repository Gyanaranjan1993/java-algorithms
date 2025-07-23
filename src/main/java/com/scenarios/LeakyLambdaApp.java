package com.scenarios;

import java.util.Timer;
import java.util.TimerTask;

public class LeakyLambdaApp {
    private final byte[] bigMemory = new byte[50 * 1024 * 1024]; // 50MB dummy data

    public void scheduleTask() {
        Timer timer = new Timer("LeakyTimer", true);

        // ❌ Lambda captures 'this' → Leaks entire LeakyLambdaApp instance
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task running...");
                // Implicitly holds reference to outer class (LeakyLambdaApp.this)
                System.out.println("Memory size: " + bigMemory.length);
            }
        }, 1000, 50000);
    }

    public static void main(String[] args) throws Exception {
        LeakyLambdaApp app = new LeakyLambdaApp();
        app.scheduleTask();

        System.out.println("App scheduled. Nullifying reference.");
        // Try to make it GC-eligible
        app = null;

        // Suggest GC and wait
        System.gc();
        Thread.sleep(90000); // Give time for GC and observe memory in VisualVM or MAT
    }
}
