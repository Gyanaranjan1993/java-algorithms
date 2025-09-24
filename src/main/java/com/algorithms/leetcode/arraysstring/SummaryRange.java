package com.algorithms.leetcode.arraysstring;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
    public List<String> summaryRanges(int[] nums) {
            List<String> op = new ArrayList<>();

            for(int i = 0; i < nums.length; i++) {
                int j = i;

                while(j+1 < nums.length && nums[j+1] == nums[i] + 1){
                    j++;
                }

                if(j > i){
                    op.add(nums[i] + "->" + nums[j]);
                } else {
                    op.add(String.valueOf(nums[i]));
                }

                i = j;

            }
        return op;
    }
}
