package com.algorithms.designpatterns.solid;

public class BirdsDemo {
    public static void main(String[] args) {
        // Violates the Liskov Substitution Principle (LSP) if we try to use Penguin as a Bird
        // because Penguin cannot fly.
        Swimmable flyableBird = new Penguin();
    }
}
