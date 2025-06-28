package com.algorithms.leetcode;

public class ReverseWordsInAString {
    public String reverseWords(String s) {

        //trim the string to remove leading spaces
        //split the string based on spaces
        //loop that array in reverse order, create a stringbuilder and add to it
        //while adding I can make sure that extra spaces are trimmed as well.
        if(!s.contains(" "))
            return s;

        String trimmed = s.trim();
        String[] words = trimmed.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = words.length -1; i>=0 ;i--){
            String w = words[i].trim();
            sb.append(w);
            if(i>0){
                sb.append(" ");
            }
        }

        return sb.toString();
    }


    static String reverse(String s){
        if(!s.contains(" "))
            return s;

        int leftIndex, rightIndex = 0;
        boolean foundLetter = false;
        StringBuilder sb = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i--){
            if(Character.isLetterOrDigit(s.charAt(i)) && !foundLetter){
                foundLetter = true;
                rightIndex = i;
            } else if(s.charAt(i) == ' ' && foundLetter ) {
                foundLetter = false;
                leftIndex = i;
                sb.append(s, leftIndex+1, rightIndex+1);
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String reversed = reverse("the sky is blue");
    }
}
