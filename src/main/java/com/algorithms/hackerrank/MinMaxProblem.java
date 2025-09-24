package com.algorithms.hackerrank;

import java.util.List;

public class MinMaxProblem  {
    public static void miniMaxSum(int[] arr) {
        long totalSum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            totalSum += num;
            if (num < min) min = num;
            if (num > max) max = num;
        }

        long minSum = totalSum - max;
        long maxSum = totalSum - min;

        System.out.println(minSum + " " + maxSum);
    }

    public static void miniMaxSum2(List<Integer> arr) {
        // Write your code here
        long minSum = 0;
        long maxSum = 0;
        for(int i =0; i< arr.size(); i++) {
            int sum = 0;
            for(int j = 0; j <= 4; j++){
                if(j != i){
                    sum += arr.get(j);
                }
            }

            minSum = Math.min(minSum, sum);
            maxSum = Math.max(sum, maxSum);

        }

        System.out.print(minSum + " " + maxSum);


    }

    public static void main(String[] args) {
        miniMaxSum2(List.of(1,2,4,5,6));
    }
}
