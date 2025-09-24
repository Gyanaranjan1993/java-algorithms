package com.multithreading;

import java.util.LinkedList;

public class PickerHandler implements Runnable {
    final WarehouseWorker worker;

    public PickerHandler(WarehouseWorker worker) {
        this.worker = worker;
    }

    @Override
    public void run() {
        worker.picking();
    }
}
