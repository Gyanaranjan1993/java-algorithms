package com.algorithms.hackerrank;

import java.util.List;

public class DivisibleSumPairs {
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        int pairs = 0;
        for(int i = 0; i < ar.size()-1; i++){
            for(int j = i ; j < ar.size() ; j++){
                if(ar.get(i) + ar.get(j) == k){
                    pairs++;
                }
            }
        }
        return pairs;
    }

}
