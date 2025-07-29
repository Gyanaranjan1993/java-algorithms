package com.multithreading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentTaskExector {
    private final ConcurrentHashMap<String, AtomicInteger> counterMap = new ConcurrentHashMap<>();

    public void increment(String user){
        counterMap.compute(user, (u, count) -> {
            if(count == null) return new AtomicInteger(1);
            count.incrementAndGet();
            return count;
        });


    }

    public  static <T extends Number> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public void decrement(String user){
        counterMap.computeIfPresent(user, (u, count) -> {
            if(count.decrementAndGet() == 0){
                return null;
            }
            return count;
        });
    }
    public int getCurrentTaskCount(String userId) {
        return counterMap.getOrDefault(userId, new AtomicInteger(0)).get();
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentTaskExector cte = new ConcurrentTaskExector();

        Runnable r = () -> {
            String user = ThreadLocalRandom.current().nextBoolean() ? "userA" : "userB";
            cte.increment(user);
            System.out.println(Thread.currentThread().getName() + "->Incremented for user :" + user + "(count is-> " + cte.getCurrentTaskCount(user));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            cte.decrement(user);
            System.out.println(Thread.currentThread().getName() + "->Decremented for user :" + user + "(count is-> " + cte.getCurrentTaskCount(user));
        };

        ExecutorService service = Executors.newFixedThreadPool(4);
        for(int i =0; i< 10; i++){
            service.submit(r);
        }

        service.awaitTermination(10000, TimeUnit.SECONDS);
    }
}
