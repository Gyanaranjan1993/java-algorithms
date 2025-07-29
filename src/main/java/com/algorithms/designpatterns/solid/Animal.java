package com.algorithms.designpatterns.solid;

// This interface defines the basic behaviors of an animal.
// It breaks Interface Segregation Principle (ISP) by forcing all animals to implement methods that may not be applicable to them.
// For example, a fish would not implement fly or walk methods.
public interface Animal {
    void fly();
    void swim();
    void walk();
    void eat();
    void sleep();   
    void makeSound();
}
