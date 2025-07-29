package com.algorithms.designpatterns.decorator;

public class BasicPicker implements Picker {
    @Override
    public void pick() {
        System.out.println("Picking items using basic picking strategy.");
    }

}
