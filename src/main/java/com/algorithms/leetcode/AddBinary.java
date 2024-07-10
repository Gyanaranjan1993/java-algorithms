package com.algorithms.leetcode;

/*
    Given two binary strings a and b, return their sum as a binary string.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        /*
          Addition of 1 and 0 -> 1
          Addition of 1 and 1 -> 2

          so if the sum is greater than 1, we carry 1, else carry zero
            If sum 0 res is 1,     carry is 0
            If sum 1 res is 1,     carry is 1
            If sum is 2 res is 0,  carry is 1
            If sum is 3 res is 1 , carry is 1
         */
        while(i >= 0 || j >= 0) {
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2); // Doing modulo, so we get when sum-> 3, res -> 1, sum->2 then res-0, sum->1 then res=1
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
