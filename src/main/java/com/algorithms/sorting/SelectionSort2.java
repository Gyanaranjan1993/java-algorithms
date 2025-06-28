package com.algorithms.sorting;

public class SelectionSort2 {

    void  sort(int[] arr){
        int i, j, tempIndex=0;
        int n = arr.length;
        for(i = 0; i < n ; i++){
            tempIndex = i;
            for(j = i+1; j < n; j++){
                if(arr[j] < arr [i]){
                    tempIndex = j;
                }
             int temp = arr[i];
             arr[i] = arr[tempIndex];
             arr[tempIndex] = temp;

            }
        }
    }


}
