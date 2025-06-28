package com.algorithms.sorting;

public class BubbleSort2 {

    static void sort(int[] arr){
        int i, j, temp;
        int n = arr.length;
        boolean swapped = false;

        for(i = 0; i < n ; i++){
            swapped = false;
            for(j = 0 ; j < n - i -1; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }

                if(!swapped) break;
            }
        }


    }
}
