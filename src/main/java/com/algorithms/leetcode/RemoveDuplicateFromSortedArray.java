package com.algorithms.leetcode;

public class RemoveDuplicateFromSortedArray {

    /*

     Start an index pointer with value 0;

     Loop through the array from the second element as the first element is not the part of the loop as
     it has to be present in the output anyway.

     if the element of the array at current index pointer is not equal to the next element
     of the array, then increment the index and add the next element to the  array at the incremented index position.

     Else just move to the next element in the array.

     At the end increment index by 1 as we started from zero and return

     */
    public static int removeDuplicates(int[] nums) {
        int index = 0;

        //time complexity = o(n)
        for(int i = 1; i< nums.length; i++ ){
            if(nums[index] < nums[i]){
                nums[++index] = nums[i];
            }
        }

        return ++index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates(nums);
        System.out.println("Hi");
    }
}
