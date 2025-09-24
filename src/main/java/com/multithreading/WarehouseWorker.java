package com.multithreading;

public class WarehouseWorker {
    private static final Object pickingCartLock = new Object();
    private static final Object packagingZoneLock = new Object();


    public void picking() {
        synchronized (pickingCartLock){
            System.out.println(Thread.currentThread().getName() +": Locked Picking Cart");

            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (packagingZoneLock) {
                System.out.println(Thread.currentThread().getName()+ ": Locked Packaging Zone");
            }
        }
    }

    public void packing() {
        synchronized (packagingZoneLock){
            System.out.println(Thread.currentThread().getName() + ": Locked Picking Cart");

            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (pickingCartLock) {
                System.out.println(Thread.currentThread().getName() + ": Locked Packaging Zone");
            }
        }
    }
}
