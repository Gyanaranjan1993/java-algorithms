package com.algorithms.leetcode.arraysstring;

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
            } else if((s.charAt(i) == ' ' && foundLetter)) {
                foundLetter = false;
                leftIndex = i;
                sb.append(s, leftIndex+1, rightIndex+1);
                sb.append(" ");
            } else if(i == 0) {
                sb.append(s, i, rightIndex+1);
            }
        }

        return sb.toString();
    }

    static String reverse2(String s) {
        if (!s.contains(" ")) return s;
        StringBuilder sb = new StringBuilder();
        String trimmed = s.trim();

        while (trimmed.contains(" ")) {
            String word = trimmed.substring(trimmed.lastIndexOf(" ") + 1);
            sb.append(word);
            trimmed = trimmed.substring(0, trimmed.lastIndexOf(" ")).trim();
            sb.append(" ");
        }

        return sb.append(trimmed).toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse2("the sky  is blue"));
    }
}
