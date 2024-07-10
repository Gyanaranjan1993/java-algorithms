package com.algorithms.sorting;

// Big-O - N^2 - We need to make n iterations and in each iteration we have to check all n elements.
// Not suitable for large datasets due to too many executions

/*
    Traverse from left to right.
    Compare adjacent element and if a number is greater than the adjacent element, swap both of them.
    In each loop, we will be putting the highest number in the rightmost position which makes that item
    sorted. In the next iteration we don't consider that item.

    e.g.
    5,2,3,1,4

    First pass:- 2,5,3,1,4
    Second pass:- 2,3,5,1,4
    third pass:2,3,1,5,4
    fourth pass: 2,3,1,4,5
    fifth pass: 2,1,3,4,5
    sixth pass: 1,2,3,4,5

    Big O - N ^ 2.
 */
public class BubbleSort {

    static void bubbleSort(int[] arr){
        int n = arr.length;
        int i,j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;

            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        bubbleSort(new int[]{5,2,3,1,4});
    }
}
