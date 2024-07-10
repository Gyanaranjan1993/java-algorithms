package com.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
    Given two strings ransomNote and magazine,
    return true if ransomNote can be constructed by using the letters from
    magazine and false otherwise.

    Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> countMap = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++){
            countMap.put(magazine.charAt(i), countMap.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for(int i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            if (!countMap.containsKey(ch) ||
                countMap.get(ch) == 0) {
                return false;
            } else {
                countMap.put(ch, countMap.get(ch) - 1);
            }
        }

        return true;

    }


    public static void main(String[] args) {
        boolean res = canConstruct("aa", "aab");
    }
}
