package com.multithreading;

public class WriterRunnable implements Runnable {
    private final ReaderWriter readerWriter;

    public WriterRunnable(ReaderWriter readerWriter) {
        this.readerWriter = readerWriter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            readerWriter.write(String.valueOf(i), "text"+ i);
        }
    }
}
