package com.multithreading.reentrantlock;

import java.util.Random;

public class BankSimulator {
    public static void main(String[] args) {
        Account account1 = new Account(1, 2000);
        Account account2 = new Account(2, 2000);
        Account account3 = new Account(3, 2000);

        Account[] accounts = {account1, account2, account3};
        Random random = new Random();

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                int from = random.nextInt(3);
                int to;
                do{
                    to = random.nextInt(3);
                } while (from == to);

                int amount = random.nextInt(200);
                TransferManager.transferMoney(accounts[from], accounts[to], amount);
            }
        };

        new Thread(runnable).start();
    }
}
