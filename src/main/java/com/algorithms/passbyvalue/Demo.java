package com.algorithms.passbyvalue;

public class Demo {
    static void printNum(int n){
        n++;
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 5;
        n++;
        printNum(n);
        System.out.println(n);
    }
}
