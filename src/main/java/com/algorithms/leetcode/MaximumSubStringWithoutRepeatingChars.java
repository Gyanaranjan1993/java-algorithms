package com.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumSubStringWithoutRepeatingChars {

    /*
        Using hashmap and sliding window.

        Keep 2 pointers left & right, loop through the string using right.
        For every char, add it to the map, If it's already present in the map, increase the count.

        When the count is more than 1, it means, the char is getting duplicated.
            So add -1 to the count of that char and increment the left pointer by 1.

            Perform the above step till the count becomes equal to 1.

            The idea is we move the left pointer as much as we decrease the repeating char's count.
     */
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> count = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c, 0) + 1);

            while (count.get(c) > 1) {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstringUsingSet(String s) {
        int maxLength = 0;
        int left = 0;
        List<Character> charSet = new ArrayList<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (!charSet.contains(c)) {
                charSet.add(c);
            } else {
                while (charSet.contains(c)) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
