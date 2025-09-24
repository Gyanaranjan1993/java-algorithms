package com.algorithms.hackerrank;

public class TowerBreakers {
    public static int towerBreakers(int n, int m) {
        // Write your code here
        if(m == 1 || n % 2 == 0)
            return 2;
        else
            return 1;
    }

}
