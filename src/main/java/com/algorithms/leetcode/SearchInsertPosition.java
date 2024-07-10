package com.algorithms.leetcode;

/*
Given a sorted array of distinct integers and a target value,
return the index if the target is found. If not, return the index where it would be if it
were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInsertPosition {

    /*
       Use binary search to calculate the mid-index. If target is less than the value at index,
       then we know the target must lie in the first half. Otherwise, it must be in the second half.
       So we update the firstIndex or the lastIndex accordingly.
     */
    public int searchInsert(int[] nums, int target) {
        int fIndex = 0;
        int lIndex = nums.length;
        int mIndex;

        if(target > nums[lIndex - 1]){
            return lIndex;
        }

        while(fIndex <= lIndex){
            mIndex = (fIndex + lIndex) / 2;

            if(nums[mIndex] == target){
                return mIndex;
            } else if(target < nums[mIndex]){
                lIndex = mIndex - 1;
            } else {
                fIndex = mIndex + 1;
            }
        }

        return fIndex;
    }
}
