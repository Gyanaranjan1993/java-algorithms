package com.multithreading.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final Lock lock = new ReentrantLock();
    private int id;
    private int balance;

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public Lock getLock() {
        return lock;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public boolean withdraw(int amount) {
        if(balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }
}
