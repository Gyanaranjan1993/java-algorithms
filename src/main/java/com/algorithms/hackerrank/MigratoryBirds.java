package com.algorithms.hackerrank;

import java.util.List;

public class MigratoryBirds {
    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        int[] res = new int[5];
        for(int n : arr) {
            res[n-1]++;
        }

        int max = 0;
        int maxPos=0;
        for(int i = 0 ; i < 5 ; i++){
            if(res[i] > max) {
                max = res[i];
                maxPos = i;
            }
        }

        return maxPos + 1;
    }
}
