package com.algorithms.designpatterns.singleton;

import java.util.concurrent.atomic.AtomicBoolean;

public class Singleton {
    private static Singleton instance;
    private static AtomicBoolean initialized = new AtomicBoolean(false);

    private Singleton(){}

    public static Singleton getInstance() {
        if(!initialized.get()) {
            synchronized (Singleton.class) {
                if (instance == null) { // Double-checked locking
                    instance = new Singleton();
                    initialized.set(true);
                }
            }
        }
        return instance;
    }
}
