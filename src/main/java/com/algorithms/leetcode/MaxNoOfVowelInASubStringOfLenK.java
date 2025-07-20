package com.algorithms.leetcode;

import java.util.Set;

public class MaxNoOfVowelInASubStringOfLenK {
    public static int maxVowels(String s, int k) {
        int windowStart = 0;
        int maxVowelCount = 0, vowelCount = 0;
        final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            if (vowels.contains(s.charAt(windowEnd))) vowelCount++;
            if (windowEnd >= k - 1) {
                maxVowelCount = Math.max(maxVowelCount, vowelCount);
                if (vowels.contains(s.charAt(windowStart)))
                    vowelCount--;
                windowStart++;
            }
        }

        return maxVowelCount;
    }

    private static boolean isVowel(char c) {
        char lowerCase = Character.toLowerCase(c);
        return "aeiou".indexOf(lowerCase) != -1;
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("leetcode", 3));
    }
}
