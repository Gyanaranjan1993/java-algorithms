package com.multithreading;

public class FactorialWorker implements Runnable {
    private final FactorialCalculator factorialCalculator;
    private final int[] numArray;

    public FactorialWorker(FactorialCalculator factorialCalculator, int[] numArray) {
        this.factorialCalculator = factorialCalculator;
        this.numArray = numArray;
    }

    @Override
    public void run() {
        for(int n : numArray) {
            try {
                System.out.println(Thread.currentThread().getName() +"->Calculating factorial of : " + n);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": factorial of " + n + "is " +factorialCalculator.getFactorial(n));
        }
    }
}
