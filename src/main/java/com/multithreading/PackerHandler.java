package com.multithreading;

public class PackerHandler implements Runnable {
    final WarehouseWorker worker;

    public PackerHandler(WarehouseWorker worker) {
        this.worker = worker;
    }

    @Override
    public void run() {
        worker.packing();
    }
}
