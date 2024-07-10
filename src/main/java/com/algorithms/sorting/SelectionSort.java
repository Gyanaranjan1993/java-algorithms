package com.algorithms.sorting;

public class SelectionSort {
    /*
        Repeatedly selects the largest(or the smallest) element
        in the unsorted portion of the list and swap it with the first element
        of the unsorted portion of the list. Repeats the process until
        remaining unsorted portion is sorted.

        e.g. 5,2,3,1,4

        first pass: 1,2,3,5,4
        second pass: 1,2,3,5,4
        third pass: 1,2,3,5,4
        fourth pass: 1,2,3,4,5

        Big(O) - time complexity is O(n^2). Because we have to use 1 loop to iterate over the array
        and another to compare all the elements in to find the smallest number.

        Both the steps can be quadrupled if the size of the elements in the array is doubled.
     */
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
