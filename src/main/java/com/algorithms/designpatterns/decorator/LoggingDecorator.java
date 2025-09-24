package com.algorithms.designpatterns.decorator;

public class LoggingDecorator implements Picker {
    private final Picker picker;

    public LoggingDecorator(Picker picker) {
        this.picker = picker;
    }

    @Override
    public void pick() {
        System.out.println("Logging: Starting the picking process.");
        picker.pick();
        System.out.println("Logging: Finished the picking process.");
    }

}
