package com.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TradingBook {
    private final Queue<String> queue = new LinkedList<>();
    private final int SIZE = 5;

    public synchronized void produce(String s) throws InterruptedException {
        while (queue.size() == SIZE){
            System.out.println("Queue full, waiting to produce");
            wait();
        }

        queue.offer(s);
        System.out.println("produced :" + s);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (queue.isEmpty()){
            System.out.println("Queue full, waiting to consume");
            wait();
        }

        System.out.println("Consumed" + queue.poll());
        notify();
    }

    public static void main(String[] args) {
        TradingBook tradingBook = new TradingBook();

        Runnable producer = () -> {
            for(int i =0; i< 15; i++) {
                try {
                    tradingBook.produce("Text->" + i);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable consumer = () -> {
            for(int i =0; i< 15; i++) {
                try {
                    tradingBook.consume();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(producer);
        service.submit(consumer);
        service.submit(producer);



    }
}
