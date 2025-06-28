package com.algorithms.dfs;

public class LinkedListCycle {
 // 0 +0 = 0, carry = 0
 // 1+ 1 = 1, carry = 1
 // sum = 3, binary = 1, carry = 1
 // sum = 2, binSum = 0, carry = 1
 String addBinary(String s1, String s2) {

     int i = s1.length()-1;
     int j = s2.length()-1;

     int carry=0;

     StringBuilder sb =  new StringBuilder();

     while(i >= 0 || j >= 0){
         int sum = carry;
         int a = Integer.parseInt(String.valueOf(s1.charAt(i)));
         int b = Integer.parseInt(String.valueOf(s2.charAt(i)));
         sum = a + b;
         carry = sum > 1 ? 1 : 0;

         int res = sum % 2;
         sb.append(res);
         i--;
         j--;
     }

     return sb.reverse().toString();


 }


}
