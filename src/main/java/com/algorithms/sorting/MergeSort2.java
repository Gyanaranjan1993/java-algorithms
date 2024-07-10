package com.algorithms.sorting;

import java.util.Arrays;

public class MergeSort2 {

    static void mergeSort(int[] arr) {

        if(arr.length == 1)
            return;
        int mid = arr.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < mid) {
                leftArr[i] = arr[i];
            } else {
                rightArr[j] = arr[i];
                j++;
            }
        }

        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, arr);
    }
    static void merge(int[] leftArr, int[] rightArr, int[] arr){
        int leftSize  = arr.length / 2;
        int rightSize = arr.length - leftSize;
        int i=0, l=0, r=0;

        while(l < leftSize && r < rightSize){
            if(leftArr[l] < rightArr[r]){
                arr[i] = leftArr[l];
                i++;
                l++;
            } else {
                arr[i] = rightArr[r];
                i++;
                r++;
            }
        }

        while(l < leftSize){
            arr[i] = leftArr[l];
            i++;
            l++;
        }

        while (r < rightSize){
            arr[i] = rightArr[r];
            i++;
            r++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 0, 6, 9, 3, 10};

        mergeSort(arr);

        System.out.println("Sorted Array is - " + Arrays.toString(arr));
    }
}
