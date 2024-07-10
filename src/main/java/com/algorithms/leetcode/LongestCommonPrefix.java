package com.algorithms.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {

    /**
     * First use Arrays.sort to sort the array of strings in alphabetic order.
     * Once done, take the first element and last element in the array, from which we can get the LCP
     * then check each char in both the elements and increment a counter as long as we find match.
     * when we find a mismatch, we break the loop.
     * Then we can find the LCP as a substring of first element from zeroth char to the incremented counter.
     *
     * @param strs
     * @return
     */
    static String longestPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }

        if (prefix.isEmpty()) return "";

        return prefix;
    }

    static String longestCommonPrefixEfficiently(String[] strs){
        if (strs.length == 0) return "";

        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if (s1.charAt(idx) != s2.charAt(idx))
                break;
            idx++;
        }
        if (idx > 0)
            return s1.substring(0, idx);
        else
            return "";
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"flower","floght","flow"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
        System.out.println("LCP is : " + longestPrefix(strings));
        System.out.println("LCP1 is :" + longestCommonPrefixEfficiently(strings));
    }
}
