package com.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockExample {
    private static final Object pickingCartLock = new Object();
    private static final Object packagingZoneLock = new Object();

    public static void main(String[] args) {
//        WarehouseWorker worker = new WarehouseWorker();
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.execute(() -> {
//            PickerHandler handler = new PickerHandler(worker);
//            handler.worker.picking();
//        });
//
//        executorService.execute(() -> {
//            PickerHandler handler = new PickerHandler(worker);
//            handler.worker.packing();
//        });


        Thread t1 = new Thread(new Worker());
        t1.start();

        synchronized (packagingZoneLock){
            System.out.println("packing");

            synchronized (pickingCartLock){
                System.out.println("picking");
            }
        }
    }

    static class Worker implements Runnable{

        @Override
        public void run() {
            synchronized (pickingCartLock) {
                System.out.println("picking");

                synchronized (packagingZoneLock) {
                    System.out.println("Packing");
                }
            }
        }
    }
}
