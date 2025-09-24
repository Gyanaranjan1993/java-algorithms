package com.algorithms.hackerrank;

public class StaircaseDetail {
    public static void staircase(int n) {
        // Write your code here
        // When n = 5, print 4 spaces, 1 #
        // n = 4 , print 3 spaces, 2 symbols
        // n =3, print 2 spaces, 3 symbols
        // n =2, 1 space, 4 symbols
        // n = 0

        StringBuilder sb = new StringBuilder();
        for (int a = n; a >= 1; a--) {
            int noOfSpaces = a - 1;
            int symbols = n - noOfSpaces;
            for (int i = 1; i <= noOfSpaces; i++)
                sb.append(" ");
            for (int j = 1; j <= symbols; j++)
                sb.append("#");
            if (a != 1)
                sb.append("\n");

        }

        System.out.println(sb.toString());
    }


    void staircase2(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(" ".repeat(n - i) + "#".repeat(i));
        }
    }
}
