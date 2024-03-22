package com.algorithms.sorting;

public class InsertionSort {
    void insertionSort(int[] arr){
        for(int i =1; i< arr.length ; i++){
            int key = arr[i];
            int j = i - 1;
            while(j > -1 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
