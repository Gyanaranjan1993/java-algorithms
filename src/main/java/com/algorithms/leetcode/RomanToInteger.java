package com.algorithms.leetcode;

import java.util.Scanner;

public class RomanToInteger {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num;

        System.out.println("Enter Roman numeral");
        String roman = in.nextLine();

        if (roman.length() > 15) {
            System.err.println("Can not work with roman number more than 15 chars");
        } else {
            num = new RomanToInteger().romanToInt3(roman.toUpperCase());
            System.out.println("Integer is :" + num);
        }
    }

    private int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    /**
     * logic here is that we loop through the roman numeral, if the previous is less than current one, we subtract
     * twice of that from the current sum. This is because it's already added in the previous iteration where it would
     * have been subtracted.
     *
     * @param s
     * @return
     * MXI
     * IX
     */
    private int romanToInt(String s){
        int num = 0;
        int l = s.length();

        //assign the last to maximum roman numeral
        int last = 1000;

        for(int i=0; i<l ; i++){
            int value = getValue(s.charAt(i));

            if(value > last)
                num = num - last * 2;  //-10 -60

            num = num + value;//10 40
            last = value; // 10 50
        }

        return num;
    }
//xxi
//10 10 1


// private int romantoInt2(String s){
//
//        if (s.length() == 1){
//            return getValue(s.charAt(0));
//        }
//
//
//
//        int lastIndex = s.length() - 1;
//        int num = 0;
//
//        for(int i = lastIndex; i >= 0 ; i--){
//            int currentV = getValue(s.charAt(i));
//            if (i == 0){
//                int cure
//            } else {
//                int previousV = getValue(s.charAt(i - 1));
//
//                if (currentV >= previousV){
//                    num = num + currentV;
//                } else {
//                    num = num - currentV;
//                }
//            }
//
//        }
//
//
//
//
//
//
//
//
//
// }
 //XIX
 //10 1 10-1
private int romanToInt3(String s) {
    int length = s.length() - 1;
    int num = getValue(s.charAt(length));


    for (int i = length; i >= 0; i--) {
        if (i == 0) {
            return num;
        }

        int currV = getValue(s.charAt(i));
        int prevV = getValue(s.charAt(i - 1));
        if (currV > prevV) {
            num = num - prevV;
        } else {
            num = num + prevV;
        }
    }

    return num;

}
}
