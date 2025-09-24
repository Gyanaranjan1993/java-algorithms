package com.algorithms.leetcode.hashset;

import java.util.HashSet;
import java.util.Set;

public class Panagram {
    public boolean checkIfPangram(String sentence) {
        // TODO: Write your code here
        Set<Character> elements = new HashSet<>();
        for(int i = 0; i< sentence.length(); i++) {
            if(Character.isAlphabetic(sentence.charAt(i))){
                elements.add(Character.toLowerCase(sentence.charAt(i)));
            }
        }
        return elements.size() == 26;
    }
}
