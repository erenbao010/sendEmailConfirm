package com.example.CTGTDL.array;

import java.util.HashMap;
import java.util.Map;

public class LC605 {
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int result = n;
            int flowerRemain = 0;
            for (int i=1; i<flowerbed.length;i++) {
                if (flowerbed[i]==0 ) {
                    if (flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0) {
                        result--;
                    }
                }

            }
            return n<=0;
        }
    }
    class Solution1 {
        public int[] twoSum(int[] nums, int target) {

            for (int i = 0; i< nums.length-1; i++ ) {
                for (int j=i+1; j<nums.length;j++) {
                    if(nums[i]+ nums[j]== target){
                        return new int[] {i,j};
                    }
                }
            }
            return nums;
        }
    }
    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> store = new HashMap<>();

            for (int i = 0; i< nums.length; i++) {
                Integer complementIndex = store.get(nums[i]);
                if (!(complementIndex==null)) {
                    return new int[] {i,complementIndex};
                }
                store.put(target-nums[i], i);
            }
            return nums;
        }
    }
}
