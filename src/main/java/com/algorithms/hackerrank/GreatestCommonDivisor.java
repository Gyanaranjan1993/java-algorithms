package com.algorithms.hackerrank;

public class GreatestCommonDivisor {
    public static int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static int gcdOfArray(int[] arr){
        int res = arr[0];
        for(int i=1; i< arr.length ; i++){
            res = gcd(res, arr[i]);
        }

        return res;
    }

    public static int lcm(int a, int b){
        int lcm = a * (b /gcd(a,b));
        return lcm;
    }
}
