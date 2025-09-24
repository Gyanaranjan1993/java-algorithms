package com.algorithms.leetcode.twopointers;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> leftArr = new ArrayList<>();
        List<int[]> rightArr = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];

        for(int[] interval : intervals){
            int left = interval[0];
            int right = interval[1];

            if (right < start) {
                leftArr.add(interval);
            } else if (left > end) {
                rightArr.add(interval);
            } else {
                start = Math.min(start, left);
                end = Math.max(end, right);
            }
        }

        List<int[]> merged = new ArrayList<>(leftArr);
        merged.add(new int[]{start, end});
        merged.addAll(rightArr);

        return merged.toArray(new int[merged.size()][]);
    }
}
