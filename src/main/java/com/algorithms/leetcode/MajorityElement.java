package com.algorithms.leetcode;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.


    Sol - this can be done in three ways

        Sorting - We sort the array. After sorting the number that's present more than n/2 times should be
        present in n/2 th location.

        Using HashMap - Loop through array, keep a map of a specific number and increment the count
                        for each number as you go through the loop.

                        Afterward, loop through the hashMap, find out the value with the highest count.

        Moore's voting algo -

            Initialize two variables: count and candidate. Set count to 0 and candidate to an arbitrary value.
            Iterate through the array nums:
                a. If count is 0, assign the current element as the new candidate and increment count by 1.
                b. If the current element is the same as the candidate, increment count by 1.
                c. If the current element is different from the candidate, decrement count by 1.

            After the iteration, the candidate variable will hold the majority element.

            Complexity = O(n)
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int n : nums) {
            if(count == 0) {
                candidate = n;
                count ++;
            } else if (candidate == n){
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
