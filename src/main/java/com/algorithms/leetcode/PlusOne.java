package com.algorithms.leetcode;

/*
You are given a large integer represented as an integer array digits,
where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least
significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:

    Input: digits = [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.
    Incrementing by one gives 123 + 1 = 124.
    Thus, the result should be [1,2,4].

Example 2:

    Input: digits = [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.
    Incrementing by one gives 4321 + 1 = 4322.
    Thus, the result should be [4,3,2,2].

Example 3:

    Input: digits = [9]
    Output: [1,0]
    Explanation: The array represents the integer 9.
    Incrementing by one gives 9 + 1 = 10.
    Thus, the result should be [1,0].
 */
public class PlusOne {

    public static int[] plusOne(int[] digits){

        /*
           Loop through array backwards. If we find the last most integer as less than 9, then we can just increment
           it by 1 and return the new array. After we take care of last integer, we move to next position and do the same.

           e.g. for [1,9,1] -> the last number is 1,so we increment last number as 1 and just return the new array.
                for [1 ,9, 9] -> last number is 9, update it to 0 and go the next int which is again 9.
                so we again set the next int to 0 and move on to the next which is 1. As it's less than 9, we
                increment it by 1.

                [1,9,9] -> [1,9,0] -> 1,0,0 -> 2,0,0

                for [9,9,9,9] -> All the integers are updated to 0 which becomes [0,0,0,0]
                But in this case we need to allocate a new array with length 1 more than the existing array and
                set the very first index to 1. The rest of the indexes will be by default 0
         */
        for(int i = digits.length - 1; i >= 0 ; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newArr = new int[digits.length + 1];
        newArr[0] = 1;
        return newArr;
    }
}
