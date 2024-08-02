package com.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    You are given an array of non-overlapping intervals where intervals[i] = [starti, endi] represent the start and
    the end of the ith interval and intervals is sorted in ascending order by starti.
    You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
    still does not have any overlapping intervals (merge overlapping intervals if necessary).

    Return intervals after the insertion.

    Note that you don't need to modify intervals in-place. You can make a new array and return it.
 */
public class InsertInterval {

    /*
        We create two lists - left & right
        1. if a specific interval ends before the new interval starts, then it belongs to the left array.
        2. If the interval begins after the new interval ends , then it belongs to right array.
        3. If the above conditions does not meet then there must be a overlap, so we make start as
           the minimum before current interval start and the new interval start
           And the end as maximum between current interval end and new interval end.

        At the end, merge left array, [start, end] & right array
     */

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> left = new ArrayList<>();
        List<int[]> right = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];

        for (int[] interval : intervals) {
            int first = interval[0];
            int last = interval[1];

            if (last < start) {
                left.add(interval);
            } else if (first > end) {
                right.add(interval);
            } else {
                start = Math.min(first, start);
                end = Math.max(end, last);
            }
        }

        List<int[]> merged = new ArrayList<>(left);
        merged.add(new int[]{start, end});
        merged.addAll(right);

        return merged.toArray(new int[merged.size()][]);
    }
}
