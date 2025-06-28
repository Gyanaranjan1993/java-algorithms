package com.algorithms.hackerrank;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeConversion {
    private static final DateFormat TWELVE_TF = new SimpleDateFormat("hh:mm:ssa");
    private static final DateFormat TWENTY_FOUR_TF = new SimpleDateFormat("HH:mm:ss");

    public static String timeConversion(String s) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        String hrsAsString = s.substring(0,2);
        int hrs = Integer.parseInt(hrsAsString);
        if(s.contains("AM")){
            if(hrs == 12) {
                hrsAsString = "00";
            }
        } else {
            if(hrs < 12){
                hrsAsString = String.valueOf(12 + hrs);
            }
        }

        sb.append(hrsAsString).append(s, 2, 8);
        return sb.toString();
    }

    public static String timeConversion2(String s) {
        try {
            return TWENTY_FOUR_TF.format(
                    TWELVE_TF.parse(s));
        } catch (ParseException e) {
            return s;
        }
    }
}
