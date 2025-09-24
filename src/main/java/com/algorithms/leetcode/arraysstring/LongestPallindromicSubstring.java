package com.algorithms.leetcode.arraysstring;


//TODO: Review
/*
https://leetcode.com/problems/longest-palindromic-substring/solutions/6141600/video-using-two-pointers-python-javascript-java-c/
 */

public class LongestPallindromicSubstring {


    String longestPallindrome(String s){

        if(s.length() <= 1)
            return s;

        //Min length of word we should check for pallindrome is 2
        int maxLen = 2;
        String maxSubStr = s.substring(0,1);
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i + maxLen ; j <= s.length() ; j++) {
                if((j-i) >= maxLen && isPallindrome(s.substring(i, j))){
                    maxLen = j-i;
                    maxSubStr = s.substring(i, j);
                }
            }
        }

        return maxSubStr;
    }

    private boolean isPallindrome(String s){
        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }

    String longestUsingCenter(String s){

        if(s.length() <= 1)
            return s;

        String maxString = s.substring(0,1);
        for(int i=0; i< s.length(); i++){

            String odd = expandAroundCenter(s, i, i);
            String even = expandAroundCenter(s, i, i+1);

            if(odd.length() > maxString.length())
                maxString =odd;
            if(even.length() > maxString.length())
                maxString = even;
        }

        return maxString;

    }


    private String expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
