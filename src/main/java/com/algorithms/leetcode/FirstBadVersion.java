package com.algorithms.leetcode;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        if(n == 1)
            return 1;
        else {
            int start = 1;
            while(start < n) {
                int mid = start + (n - start) / 2;
// uncomment this block when you run this
//                if(isBadVersion(mid)){
//                    n = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
            }
            return start;
        }

    }
}
