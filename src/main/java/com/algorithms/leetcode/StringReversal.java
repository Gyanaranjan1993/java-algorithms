package com.algorithms.leetcode;

public class StringReversal {
    public static String reverse(String str){

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    static String reverseUsingCharArray(String str) {
        char[] charArray = str.toCharArray();

        int i = 0;
        int j = charArray.length - 1;

        while( i < j){
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        String rev = reverse("Gyana");
        System.out.println(rev);
        String rev2 = reverseUsingCharArray("Gyana");
        System.out.println(rev2);
    }

}
