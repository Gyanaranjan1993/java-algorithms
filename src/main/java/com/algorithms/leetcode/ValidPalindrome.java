package com.algorithms.leetcode;

public class ValidPalindrome {

    static boolean isPalindrome(String s){
        if(s.isEmpty()) return true;

        int i = 0;
        int j = s.length() - 1;

        while(i <= j){
            char startChar = s.charAt(i);
            char endChar = s.charAt(j);
            if(!Character.isLetterOrDigit(startChar)) {
                i++;
            }
            else if(!Character.isLetterOrDigit(endChar)) {
                j--;
            }
            else if(Character.toLowerCase(startChar)
                    != Character.toLowerCase(endChar)){
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
