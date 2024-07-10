package com.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    /*
        Create a hashmap to store each letter as key and number of occurrences as count. for the first string
        Iterate over the second tree and subtract the count of each char.

        Afterwards, Check if the count of each char in the map is zero. if yes, then both the words are anagram.
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> wordMap = new HashMap<>();

        for(char c : s.toCharArray()){
            wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()) {
            if(!wordMap.containsKey(c))
                return false;

            wordMap.put(c, wordMap.get(c) - 1);
        }

        return wordMap
                .values()
                .stream()
                .allMatch((a) -> a.equals(0));
    }
}
