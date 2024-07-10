package com.algorithms.sorting;

/*
  Compare current element to its predecessor until there are no predecessor or
  the predecessor is less than current.

  If the predecessor is greater than current, move the predecessor to the next position
  keep doing the same for all such predecessors.

  5,2,3,1,4

  1st pass: 2,5,3,1,4
  2nd pass: 2,3,5,1,4
  3rd pass: 1,2,3,5,4
  4th pass: 1,2,3,4,5

  5,4,3,1
  4,5,3,1
 */
public class InsertionSort {
    void insertionSort(int[] arr){
        for(int i = 1; i< arr.length ; i++){
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
