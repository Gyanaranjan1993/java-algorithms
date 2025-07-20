package com.algorithms.leetcode;

//2 pointer
public class ReverseVowel {

    //TC - o(n)
    //SC - o(n) because the size of char array varies according to size of input
    public String reverseVowels(String s) {
        // TODO: Write your code here
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();

        while (left < right) {
            while (left < right && !isVowel(chars[left])) left++;
            while (left < right && !isVowel(chars[right])) right--;

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);

    }

    private boolean isVowel(char c) {
        char lowerCase = Character.toLowerCase(c);
        return "aeiou".indexOf(lowerCase) != -1;
    }

}
