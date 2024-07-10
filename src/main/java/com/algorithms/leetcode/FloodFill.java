package com.algorithms.leetcode;

/*
    An image is represented by an [m x n] integer grid image where image[i][j] represents the pixel value of the image.
    You are also given three integers sr, sc, and color.
    You should perform a flood fill on the image starting from the pixel image[sr][sc]. To perform a flood fill,
    consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color
    as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and
    so on. Replace the color of the aforementioned pixels with color.
 */
public class FloodFill {
    /*
        We can apply DFS algorithm from the specified grid in scope. If the color matches we will change
        the color of the grid to the newer color and move on to the adjacent grid. We will have 4 adjacent
        grids to navigate. So if any of those grids color match, we change that color and move to the adjacent
        cells of that grid. We can keep on doing it until we hit an end i.e. if the row of the grid goes
        out of bounds or becomes less than zero and same with the column.
     */

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color ) return image;
        fill(image, sc, sr, image[sr][sc], color);
        return image;
    }

    private void fill(int[][] images, int sc, int sr, int currentColor, int newColor){

        //Establish boundary conditions, we must exit if we hit any of this
        if(sr < 0 || sr >= images.length || sc < 0 || sc >= images[0].length || images[sr][sc] != currentColor){
            return;
        }

        //Assign the new color
        images[sr][sc] = newColor;

        //Recurse in all four ways until we hit end
        fill(images, sc +1, sr, currentColor, newColor);
        fill(images, sc - 1, sr, currentColor, newColor);
        fill(images, sc, sr + 1, currentColor, newColor);
        fill(images, sc, sr - 1, currentColor, newColor);
    }
}
