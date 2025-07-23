package com.multithreading;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriter {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final Map<String, List<String>> resource = new HashMap<>();

    public void read() {
        lock.readLock().lock();
        System.out.println("Reading from thread:" + Thread.currentThread().getName());
        System.out.println(resource.values());
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock.readLock().unlock();
    }

    public void write(String key, String text) {
        lock.writeLock().lock();
        System.out.println("Writing to map from thread: " + Thread.currentThread().getName());
        if(resource.containsKey(key)){
            resource.get(key).add(text);
        } else {
            resource.put(key, new ArrayList<>(Collections.singletonList(text)));
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock.writeLock().unlock();
    }


    public static void main(String[] args) {
        ReaderWriter readerWriter = new ReaderWriter();

        ReaderRunnable readerRunnable = new ReaderRunnable(readerWriter);
        WriterRunnable writerRunnable = new WriterRunnable(readerWriter);

        ExecutorService service = Executors.newFixedThreadPool(3);

        service.submit(readerRunnable);
        service.submit(writerRunnable);
        service.submit(writerRunnable);
        service.submit(writerRunnable);

        service.shutdown();
    }

}
