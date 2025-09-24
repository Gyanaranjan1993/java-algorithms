package com.algorithms.leetcode.hashset;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");
        if(words.length != pattern.length())
            return false;

        for(int i = 0; i< pattern.length(); i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(words[i])){
                    return false;
                }
            } else if (map.containsValue(words[i])) {
                return false;
            }

            map.put(ch, words[i]);

        }

        return true;
    }
}













