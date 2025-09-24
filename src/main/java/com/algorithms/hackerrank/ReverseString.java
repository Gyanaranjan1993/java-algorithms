package com.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ReverseString {

    static String reverseString(String str){

        StringBuilder sb = new StringBuilder();
        String trimmed = str.trim();
        int endIndex = trimmed.length()-1;
        int i = endIndex-1;
        List<String> list = new ArrayList<>();
        int j = 0;
        //the sky is   blue, i=15, eI=16
        //blue, i=12, eI=12
        //
        while( i>= 0) {
            if(!Character.isAlphabetic(trimmed.charAt(i)) && Character.isAlphabetic(trimmed.charAt(i+1))){
                System.out.println("i :" + i );
                sb.append(trimmed.substring(i, endIndex+1).trim()).append(" ");
                endIndex = i;
                System.out.println("eI :" + endIndex );
            } else if (i==0) {
                sb.append(trimmed, 0, trimmed.indexOf(" "));
            }
            i--;
        }

        return sb.toString();


    }

    public static void main(String[] args) {
        System.out.println(reverseString("the sky is   blue "));
    }
}
