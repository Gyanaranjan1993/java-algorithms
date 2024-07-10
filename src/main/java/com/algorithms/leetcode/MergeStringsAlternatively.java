package com.algorithms.leetcode;

public class MergeStringsAlternatively {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;

        StringBuilder result = new StringBuilder();
        while(i < word1.length() && i < word2.length()){
            result.append(word1.charAt(i))
                    .append(word2.charAt(i));
        }

        if(i < word1.length()){
            result.append(word1.substring(i));
        }

        if(i < word2.length()){
            result.append(word2.substring(i));
        }

        return result.toString();
    }
}
