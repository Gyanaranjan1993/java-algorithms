package com.algorithms.leetcode.arraysstring;

public class HighestValuePallindrome {
    private String soluton(String s, int n, int k) {
        char[] chars = s.toCharArray();
        boolean[] changed = new boolean[n];
        int l = 0;
        int r = n - 1;

        while (l < r) {
            if (chars[l] != chars[r]) {
                if (chars[l] > chars[r]) {
                    chars[r] = chars[l];
                    changed[r] = true;
                } else {
                    chars[l] = chars[r];
                    changed[l] = true;
                }
            }
            l++;
            r--;
            k--;
        }

        if (k < 0) return "-1";

        l = 0;
        r = n - 1;

        while (l <= r) {
            if (l == r) {
                if (k >= 1) {
                    chars[l] = 9;
                }
            } else if (chars[l] != '9') {
                if (k >= 1 && (changed[l] || changed[r])) {
                    chars[l] = chars[r] = 9;
                    k--;
                } else {
                    if (k >= 2) {
                        chars[l] = chars[r] = 9;
                        k = k - 2;
                    }
                }
            }
            l++;
            r--;
        }
        return new String(chars);
    }
}
