package com.algorithms.leetcode.arraysstring;

import java.util.Arrays;
/*
    Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.



Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"
 */

public class DetermineIfTwoStringsAreClose {
    /*
        To solve this problem, we need to understand that the operations allowed don't change the frequency of characters,
        only their positions or representations. Therefore, two "close" strings must have the same set of characters and the
         same frequency of each character, although the characters themselves can be different.

        The crucial realization is that operation 1 allows us to reorder characters in any fashion,
        making the relative order of characters inconsequential. Operation 2 allows us to transform characters into each other,
        given that both characters exist in both strings. The consequence of this is:

        Both word1 and word2 must contain the same unique characters - they must have the same set of keys in their
         character counts (Counter).Both word1 and word2 must have the same character frequencies, which implies, after sorting
         their frequency counts, these should match.
     */
    public boolean closeStrings(String word1, String word2) {
        int[] left = new int[26];
        int[] right = new int[26];

        for (char c : word1.toCharArray()) {
            left[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            right[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((left[i] > 0 && right[i] == 0) || (left[i] == 0 && right[i] > 0)) return false;
        }

        Arrays.sort(left);
        Arrays.sort(right);

        for (int i = 0; i < 26; i++) {
            if (left[i] != right[i]) return false;
        }

        return true;
    }
}
