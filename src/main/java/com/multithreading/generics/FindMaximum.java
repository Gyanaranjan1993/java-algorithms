package com.multithreading.generics;

import java.util.Comparator;
import java.util.List;

public class FindMaximum {

    public <T extends Comparable<T>> T max(List<T> elements){

        return elements.stream()
                .max(Comparable::compareTo)
                .get();
    }
}
