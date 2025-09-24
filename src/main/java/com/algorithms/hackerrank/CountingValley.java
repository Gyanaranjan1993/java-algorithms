package com.algorithms.hackerrank;

public class CountingValley {
    /*
        ✅ Step-by-Step Algorithm
        Initialize elevation = 0, valleys = 0

        Loop over each step in path:

        If step is 'U': increment elevation

        If elevation becomes 0 after a step up → we just exited a valley → increment valleys

        If step is 'D': decrement elevation

        Return valleys
     */

    public int numberOfValleys(char[] path, int steps) {
        int valleys = 0;
        int elevation = 0;
        for(char ch: path) {
            if(ch == 'U') {
                elevation++;
                if(elevation == 0) valleys++;

            } else if (ch == 'D') {
                elevation--;
            }
        }
        return valleys;
    }
}
