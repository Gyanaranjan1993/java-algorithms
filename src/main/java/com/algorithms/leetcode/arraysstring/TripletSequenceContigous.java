package com.algorithms.leetcode.arraysstring;

public class TripletSequenceContigous {
    public static boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int left =0 , right = 1;

        while(right < len-1) {
            if(nums[right] > nums[left]){
                if(nums[right] < nums[right + 1]){
                    return true;
                } else {
                    right = right + 2;
                    left = left + 2;
                }
            } else {
                right++;
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1,2,3,4,5}));
    }
}
