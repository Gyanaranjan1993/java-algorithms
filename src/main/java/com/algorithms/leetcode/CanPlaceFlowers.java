package com.algorithms.leetcode;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++) {
            boolean left = i == 0 || flowerbed[i-1] == 0;
            boolean right = i == flowerbed.length -1 || flowerbed[i+1] == 0;

            if(left && right && flowerbed[i] == 0){
                flowerbed[i] = 1;
                n--;
            }
        }
        // N can go negative if there are more than enough spaced
        return n <= 0;
    }
}
