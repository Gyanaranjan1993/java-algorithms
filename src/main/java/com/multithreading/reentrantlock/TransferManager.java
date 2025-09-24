package com.multithreading.reentrantlock;

public class TransferManager {
    public static void transferMoney(Account from, Account to, int amount) {

        from.getLock().lock();
        try {
            Thread.sleep(1000);
            if(from.withdraw(amount)) {
                to.getLock().lock();
                Thread.sleep(1000);
                System.out.println("Transferring " + amount +" from " + from.getId() + " to " + to.getId());
                to.deposit(amount);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            to.getLock().unlock();
        }
        from.getLock().unlock();
    }
}
