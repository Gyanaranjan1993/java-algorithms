package com.algorithms.leetcode.arraysstring;

public class NoneDuplicateNumberInstance {
    public int moveElements(int[] arr) {
        int nextDupElement = 1;

        for(int i=1; i< arr.length-1; i++) {
            if(arr[nextDupElement-1] != arr[i]){
                arr[nextDupElement] = arr[i];
                nextDupElement++;
            }
        }
        return nextDupElement;
    }
}
