package com.algorithms.leetcode;

public class RemoveElementInAnArray {

    /*
        Keep two pointers. one pointer to loop through each element in the array.
        Another pointer to add the non-target elements into the o/p.

        For each element in the array,
          if it is not equal to the target value,
            then update that value at the index pointer and increment the index to the next
            position

        Do this above until the end of the array.
     */
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
