package com.algorithms.sorting;

import java.util.Arrays;

/*
  In this algorithm, we pick a pivot index(usually the end index), sort the pivot wrt to other elements
  in the array. Once pivot is placed at the right position, split the array by 2 partitions on the both
  the sides of the pivot. Do the same operation on the both the split partitions recursively which eventually
  sorts the array.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 3, 9, 4, 7, 6, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array :" + Arrays.toString(arr));
    }


    static void quickSort(int[] arr, int start, int end) {

        if (end <= start) return;
        int pivot = partition(arr, start, end);

        //call quick sort on the left side of the pivot
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {

        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {
            if (arr[j] < pivot) {
                if (arr[i] != arr[j]) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;

    }
}
