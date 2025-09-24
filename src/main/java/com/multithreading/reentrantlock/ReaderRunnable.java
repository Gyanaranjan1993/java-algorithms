package com.multithreading.reentrantlock;

public class ReaderRunnable implements Runnable {
    private final ReaderWriter readerWriter;

    public ReaderRunnable(ReaderWriter readerWriter) {
        this.readerWriter = readerWriter;
    }

    @Override
    public void run() {
        for(int i =0; i < 20; i++) {
            readerWriter.read();
        }
    }
}
