package com.algorithms.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Zero1Matrix {
    public int[][] updateMatrix(int[][] mat) {

        int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0},{0,-1}};
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> poller = new ArrayDeque<>();

        //Loop through the mat, push all the indexes that has value zero to the queue,
        // Because from there we can start visiting the neighbours and update the distance
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0)
                    poller.offer(new int[]{i,j});
                else
                    mat[i][j] = -1;
            }
        }

        while (!poller.isEmpty()) {
            int[] current = poller.poll();
            int r = current[0];
            int c = current[1];
            // Visit in all 4 directions, if the element is not processed (i.e. has -1)
            // then we update
            for(int[] dir : directions){
                int nr = current[0] + dir[0];
                int nc = current[0] + dir[1];

                if(nr < 0 || nr >=m || nc < 0 || nc >= n || mat[nr][nc] != -1)
                    continue;

                mat[nr][nc] = 1 + mat[r][c];
                poller.offer(new int[]{nr, nc});
            }

        }

        return mat;
    }
}
