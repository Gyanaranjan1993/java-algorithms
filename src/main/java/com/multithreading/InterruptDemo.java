package com.multithreading;

public class InterruptDemo  {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Counter());
        Thread thread2 = new Thread(new Counter());

        Thread thread3 = new Thread(new Counter2());
        Thread thread4 = new Thread(new Counter2());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(10000);
        thread1.interrupt();
        Thread.sleep(10000);
        thread2.interrupt();
        Thread.sleep(5000);
        thread3.interrupt();
        Thread.sleep(5000);
        thread4.interrupt();
    }

    static class Counter implements Runnable {
        private boolean shouldTerminate = false;

        @Override
        public void run() {
            while (!shouldTerminate) {
                System.out.println(Thread.currentThread().getName() + " happily running....");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()  +" Interrupted, now terminating...");
                    shouldTerminate = true;
                }
            }
        }
    }

    static class Counter2 implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + "still not interrupted, happily running....");
            }

            System.out.println("Gracefully exiting....");
        }
    }

}
