package com.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> set = new HashSet<>();

        while(!set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
            if(n == 1)
                return true;
        }
        return false;
    }

    static int getNextNumber(int n) {
        int sum = 0;
        while(n != 0) {
            int rem = n % 10;
            sum += rem * rem;
            n = n /10;
        }
        return sum;
    }

    static boolean isHappy2 (int n) {
        int slowPointer = getNextNumber(n);
        int fastPointer = getNextNumber(getNextNumber(n));

        while(slowPointer != fastPointer) {
            if (fastPointer == 1) return true;
            slowPointer = getNextNumber(slowPointer);
            fastPointer = getNextNumber(getNextNumber(fastPointer));
        }

        return slowPointer == 1;

    }

    public static void main(String[] args) {
        var res = isHappy(19);
    }
}
