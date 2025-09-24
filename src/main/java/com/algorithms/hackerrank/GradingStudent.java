package com.algorithms.hackerrank;

import java.util.List;

public class GradingStudent {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        for(int i=0 ; i < grades.size() ; i++) {
            int num =  grades.get(i);
            if(num >= 38 && num%5 != 0){
                if((num+1) % 5 == 0)
                    num++;
                else if((num+2) % 5 == 0)
                    num = num+2;

                grades.set(i, num);
            }


        }

        return grades;
    }
}
