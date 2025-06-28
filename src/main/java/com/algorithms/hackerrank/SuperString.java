package com.algorithms.hackerrank;

public class SuperString {
    public static int superDigit(String n, int k) {
        // Write your code here
        StringBuilder numBuilder = new StringBuilder();
        while(k > 0){
            numBuilder.append(n);
            k--;
        }
        String num = numBuilder.toString();

        while(num.length() > 1){
            num = superDigit(num);
        }

        return Integer.parseInt(num);

    }

    private static String superDigit(String s){
        long sum = 0;
        for(char c: s.toCharArray()){
            sum += c - '0';
        }

        return String.valueOf(sum);

    }
}
