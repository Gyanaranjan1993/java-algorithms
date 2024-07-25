package com.algorithms.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class ZeroOneMatrix {
    static final int[][] direction = new int[][]{{0,1}, {-1,0}, {1,0},{0,-1}};

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        for(int r = 0; r<m ; ++r){
            for(int c=0;c<n;++c){
                if(mat[r][c] == 0){
                    queue.offer(new int[]{r,c});
                } else {
                    mat[r][c] = -1;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] dir : direction) {
                int r = curr[0];
                int c = curr[1];

                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1){
                    continue;
                }
                mat[nr][nc] = mat[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        mat = updateMatrix(mat);
        for(int i = 0; i < mat.length ; i++){
            System.out.println(Arrays.toString(mat[i]));
        }
    }
}
