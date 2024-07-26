package com.example.CTGTDL;

import com.example.CTGTDL.dependencyInjection.BubbleSortAlgorithm;
import com.example.CTGTDL.dependencyInjection.SortAlg;
import com.example.CTGTDL.dependencyInjection.quickShort;
import com.example.CTGTDL.dependencyInjection.veryComplexService;

import java.util.ArrayList;
import java.util.HashMap;

public class LC26 {
    class Solution {
        public static int removeDuplicates(int[] nums) {
           int result = 0;
            for (int i =0; i <= nums.length-1; i++) {
                if (i < nums.length-1 && nums[i] == nums[i+1]) {
                   continue;
                }
                result++;
                nums[result] = nums[i];
                }
            return result;
        }
    }
}
