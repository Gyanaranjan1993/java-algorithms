package com.algorithms.hackerrank;

import java.util.Arrays;
import java.util.List;

public class GridChallenge {
    public static String gridChallenge(List<String> grid) {
        // Write your code here
        for(int i = 0 ; i < grid.size() ; i++) {
            char[] arr = grid.get(i).toCharArray();
            Arrays.sort(arr);
        }

        for(int i =0 ; i < grid.size()-1; i++) {
            for(int j =0 ; j < grid.size() ; j++) {
                if(grid.get(i).charAt(j) > grid.get(i+1).charAt(j)){
                    return "NO";
                }

            }
        }

        return "YES";

    }

}
