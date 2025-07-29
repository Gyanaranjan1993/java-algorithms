package com.algorithms.leetcode.arraysstring;

/*
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj)
such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same
elements in the same order (i.e., an equal array).
 */
public class EqualRowColumnPair {
    public int equalPairs(int[][] grid) {
        int len = grid.length;
        int count = 0;
        for(int r =0 ; r < len ; r++){
            for (int c = 0; c < len ; c++) {
                boolean match = true;
                for(int i = 0; i < len; i++) {
                    if(grid[r][i] != grid[i][c]) {
                        match = false;
                        break;
                    }
                }

                if(match) count++;
            }
        }
        return count;
    }
}
