package com.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoutingSort {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>(Collections.nCopies(100,0));

        arr.forEach(num ->
        {
            if(num < 100){
                result.set(num, result.get(num) + 1);
            }

        });

        return result;
    }

}
