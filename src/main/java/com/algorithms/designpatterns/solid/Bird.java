package com.algorithms.designpatterns.solid;

// This class represents a Bird that can fly.
// It adheres to the Single Responsibility Principle (SRP) by focusing solely on flying behavior
// and does not include swimming behavior.
// This allows for better adherence to the Liskov Substitution Principle (LSP) when
// substituting Bird with its subclasses.
public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("The bird is flying.");
    }
}
