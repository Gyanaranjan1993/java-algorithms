package com.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SherlockValidString {
    public static String isValid(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Map<Integer, Integer> freqCount = new HashMap<>();

        for (int f : freq) {
            if (f > 0) {
                freqCount.put(f, freqCount.getOrDefault(f, 0) + 1);
            }
        }

        if (freqCount.size() == 1) {
            return "YES"; // All characters have same frequency
        } else if (freqCount.size() == 2) {
            List<Integer> keys = new ArrayList<>(freqCount.keySet());
            int f1 = keys.get(0), f2 = keys.get(1);
            int c1 = freqCount.get(f1), c2 = freqCount.get(f2);

            // Case 1: One character with freq 1
            if ((f1 == 1 && c1 == 1) || (f2 == 1 && c2 == 1)) {
                return "YES";
            }

            // Case 2: One frequency off by 1 and only appears once
            if ((Math.abs(f1 - f2) == 1) && (c1 == 1 || c2 == 1)) {
                return "YES";
            }

            return "NO";
        } else {
            return "NO";
        }
    }
}
