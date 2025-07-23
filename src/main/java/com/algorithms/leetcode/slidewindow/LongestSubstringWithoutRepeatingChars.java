package com.algorithms.leetcode.slidewindow;

import java.util.HashSet;
import java.util.Set;
import static java.lang.Math.max;

public class LongestSubstringWithoutRepeatingChars {
    private int solution(String s){
        int left = 0, right = 0, maxLength =0;
        Set<Character> seen =  new HashSet<>();
        while(right < s.length()) {
            if(seen.contains(s.charAt(right))){
                seen.remove(s.charAt(left));
                left++;
            } else {
                seen.add(s.charAt(right));
                right++;
                maxLength = max(maxLength, right-left + 1);
            }

        }

        return maxLength;
    }

    private int betterSolution(String s) {
        int left = 0, maxLength =0;
        Set<Character> seen =  new HashSet<>();
        for(int right = 0; right < s.length() ; right++) {
            // Here we remove all the left elements in one go instead of removing one by one in the previous solution
            while(seen.contains(s.charAt(right))){
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(s.charAt(right));
            maxLength = max(maxLength, (right-left) + 1);
        }
        return maxLength;
    }
}
