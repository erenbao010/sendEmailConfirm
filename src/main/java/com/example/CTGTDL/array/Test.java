package com.example.CTGTDL.array;

import java.util.ArrayList;
import java.util.List;

public class Test {
    class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            List<Boolean> result = new ArrayList<>();
            int greatestNum = 0;
            for (int i = 0; i< candies.length; i++) {
                if (candies[i] > greatestNum) {
                    greatestNum = candies[i];
                }
            }
            for (int j =0; j<candies.length; j++) {
                 if (candies[j] + extraCandies >= greatestNum) {
                     result.add(true);
                 } else {
                     result.add(false);
                 }
            }
            return result;
        }
    }
}
