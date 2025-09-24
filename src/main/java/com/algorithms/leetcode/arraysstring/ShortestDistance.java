package com.algorithms.leetcode.arraysstring;

public class ShortestDistance {
        public int shortestDistance(String[] words, String word1, String word2) {
            int position1 = -1, position2 = -1, shortestDistance = words.length;

            for(int i = 0; i < words.length ; i++) {
                if(words[i].equals(word1)) position1 = i;
                if(words[i].equals(word2)) position2 = i;

                if(position1 != -1 && position2 != -1) {
                    shortestDistance = Math.min(shortestDistance, Math.abs(position1 - position2));
                }
            }
            return shortestDistance;
        }
}
