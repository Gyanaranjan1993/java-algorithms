package com.algorithms.leetcode;

public class SqRt {

    public int findSqRt(int n) {

        //Base case
        if(n == 0 || n == 1) return n;

        // For other case we use binary search,
        // Take a range between 1 and n, find mid

        int start = 1;
        int end = n;
        int mid = -1 ;

        while(start <= end) {
            mid = start + (end - start) /2;

            if (mid * mid == n) return mid;
                // If square of mid is > n, that means the sqrt lies in the first half, so change end to mid-1
            else if (mid * mid > n)
                end = mid -1;
                // Similarly if square of mid <n  then the sqrt lies in the second half. so change start to mid + 1
            else
                start = mid + 1;
        }

        return Math.round(end);
    }
}
