package com.algorithms.hackerrank;

import java.util.List;

/**
 * Sliding window
 */
public class SubArrayDivision {

    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int count = 0;

        for (int i = 0; i <= s.size() - m; i++) {
            int sum = 0;

            for (int j = 0; j < m; j++) {
                sum += s.get(i + j);
            }

            if (sum == d) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        birthday(List.of(1, 2 ,1, 3, 2), 3, 2);
    }
}
