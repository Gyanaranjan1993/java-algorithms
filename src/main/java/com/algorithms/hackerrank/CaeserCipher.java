package com.algorithms.hackerrank;

public class CaeserCipher {
    public static String caesarCipher(String s, int k) {
        // Write your code here

        StringBuilder encrypted = new StringBuilder();

        k = k % 26; // Normalize shift

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char ch = (char) ((c - 'A' + k) % 26 + 'A');
                encrypted.append(ch);
            } else if (Character.isLowerCase(c)) {
                char ch = (char) ((c - 'a' + k) % 26 + 'a');
                encrypted.append(ch);
            } else {
                encrypted.append(c); // Leave non-letters unchanged
            }
        }

        return encrypted.toString();
    }

    public static void main(String[] args) {
        caesarCipher("abcdefghijklmnopqrstuvwxyz", 3);
    }

}
