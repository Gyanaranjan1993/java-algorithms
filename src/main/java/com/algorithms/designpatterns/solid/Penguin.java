package com.algorithms.designpatterns.solid;

// This class represents a Penguin, which is a type of bird that cannot fly.
// It implements the Flyable interface but overrides the fly method to indicate that penguins cannot fly
// It also implements the Swimmable interface.
public class Penguin implements Swimmable {

    @Override
    public void swim() {
        System.out.println("The penguin is swimming.");
    }

}
