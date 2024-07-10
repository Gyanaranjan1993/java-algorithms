package com.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

    static List<List<Integer>> threeSums(int[] arr) {

        if (arr.length < 3)
            return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();

        for (int value : arr) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 2; k < arr.length; k++) {
                    if (value + arr[j] + arr[k] == 0 && value != arr[j] && value != arr[k] && arr[j] != arr[k]) {
                        List<Integer> matchedList = List.of(value, arr[j], arr[k]);

                        if (!result.contains(matchedList)) {
                            result.add(matchedList);
                        }
                    }

                }
            }
        }

        if (result.isEmpty())
            return Collections.emptyList();

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = threeSums(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);
    }
}
