package com.unomi.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Code01 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        return new int[0];

    }

    /**
     * 初始的写法
     */
   static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[nums.length * 2];
            Map<Integer, Integer> map = new HashMap<>();
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    result[j++] = map.get(target - nums[i]);
                    result[j++] = i;
                    break;
                }
                map.put(nums[i], i);
            }
            return Arrays.copyOfRange(result, 0, 2);
        }

    }
}

