package com.algorithms.leetcode.arraysstring;

public class MaximumProductSubArray {


    private int solution(int[] arr){
        int min = arr[0], max = arr[0], res = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < 0) {
                int temp =  max;
                max = min;
                min = temp;
            }

            max = Math.max(max * arr[i], max);
            min = Math.min(min * arr[i], min);

            if(max > res) res = max;
        }


        return res;

    }
}
