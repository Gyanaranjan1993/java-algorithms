package com.algorithms.leetcode;

public class CheckIfArrayIsRotatedAndSorted {

    /*
       In case of a sorted and rotated array, we expect only one occurance where an element
       of the array is greater than the previous element which is the pivot point.

       Also, we need to verify that the last element must be greater than the 0th element.

       we run a loop and check how many elements  in the array are greater than their previous ones,
       If we see more than 1, then that means that the array is not sorted.

     */
    private boolean check(int[] nums){

        int conflict = 0;
        int len = nums.length;

        for(int i=0; i < len ; i++){
            // We are comparing with (i+1) % len
            // because in this way the last comparison would be between
            // last element and first element

            if(nums[i] > nums [(i+1) % len]){
                if(++conflict > 1){
                    break;
                }
            }
        }

        return conflict <= 1;
    }
}
