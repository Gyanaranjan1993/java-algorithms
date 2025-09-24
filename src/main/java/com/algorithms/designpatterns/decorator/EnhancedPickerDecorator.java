package com.algorithms.designpatterns.decorator;

public class EnhancedPickerDecorator implements Picker {
    private final Picker picker;
    public EnhancedPickerDecorator(Picker picker) {
        this.picker = picker;
    }
    @Override
    public void pick() {
        System.out.println("Picking items using enhanced picking strategy.");
        picker.pick();
        System.out.println("Enhanced picking process completed.");
    }

}
