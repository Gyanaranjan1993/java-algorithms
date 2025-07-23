package com.multithreading;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class OrderTxn {
    private final BlockingQueue<Order> queue = new ArrayBlockingQueue<>(10);

    public void produce(Order order) {
            try {
                queue.put(order);
                System.out.println("Added Order to queue" + order);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }


    public void consume() {
        while (!queue.isEmpty()) {
            Order o = queue.poll();
            System.out.println("Consumed order" + o);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String[] args) {
        OrderTxn orderTxn = new OrderTxn();
        Runnable producer = () -> {
            for(int i = 0; i< 100; i++) {
                Order order = new Order("a", i*5, i);
                orderTxn.produce(order);
            }
        };

        Runnable consumer = orderTxn::consume;

        new Thread(producer).start();
        new Thread(consumer).start();




    }
}
